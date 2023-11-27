package Raytracer;

public class Camera extends Entity {
  private final Viewport viewport;

  public Camera(
    Vector3D lookFrom, Vector3D lookAt, Vector3D vUp, double verticalFov, Config config
  ) {
    super(lookFrom);

    Vector3D center = getPosition();

    double focalLength = lookFrom.subtract(lookAt).length();
    double theta = Math.toRadians(verticalFov);
    double h = Math.tan(theta / 2.0);

    double viewportHeight = 2.0 * h * focalLength;
    double viewportWidth = viewportHeight * config.getAspectRatio();

    // Bases para el sistema de coordenadas de la cámara.
    UnitVector3D w = lookFrom.subtract(lookAt).normalize();
    UnitVector3D u = vUp.cross(w).normalize();
    UnitVector3D v = w.cross(u).normalize();

    Vector3D viewportPosition = center.subtract(w.multiplyScalar(focalLength));

    // Vectores que definen el plano de la cámara.
    Vector3D viewportU = u.multiplyScalar(viewportWidth);
    Vector3D viewportV = v.multiplyScalar(-viewportHeight);

    this.viewport = new Viewport(viewportPosition, viewportU, viewportV, center, config);
  }

  public Ray getRay(int i, int j) {
    return viewport.getRay(i, j);
  }
}
