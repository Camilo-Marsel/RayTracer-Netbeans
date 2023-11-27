package Raytracer;

class Viewport extends Entity {
  private final Vector3D cameraPosition;
  private final Vector3D pixelDeltaU;
  private final Vector3D pixelDeltaV;
  private final Vector3D firstPixelPosition;


  public Viewport(
    Vector3D viewportCenter, Vector3D viewportU, Vector3D viewportV, Vector3D cameraPosition,
    Config config
  ) {
    super(viewportCenter);
    this.cameraPosition = cameraPosition;

    pixelDeltaU = viewportU.multiplyScalar(1.0 / (double) config.getImageWidth());
    pixelDeltaV = viewportV.multiplyScalar(1.0 / (double) config.getImageHeight());

    Vector3D viewportUpperLeft = getPosition().subtract(viewportU.multiplyScalar(0.5))
                                              .subtract(viewportV.multiplyScalar(0.5));

    firstPixelPosition = viewportUpperLeft.add(pixelDeltaU.add(pixelDeltaV).multiplyScalar(0.5));
  }

  public Vector3D raySampleSquare() {
    double px = -0.5 + Math.random();
    double py = -0.5 + Math.random();
    return pixelDeltaU.multiplyScalar(px).add(pixelDeltaV.multiplyScalar(py));
  }

  public Ray getRay(int i, int j) {
    Vector3D pixelCenter = firstPixelPosition.add(pixelDeltaU.multiplyScalar(i))
                                             .add(pixelDeltaV.multiplyScalar(j));
    Vector3D pixelSample = pixelCenter.add(raySampleSquare());

    Vector3D rayOrigin = cameraPosition;
    UnitVector3D rayDirection = pixelSample.subtract(rayOrigin).normalize();
    return new Ray(rayOrigin, rayDirection);
  }
}