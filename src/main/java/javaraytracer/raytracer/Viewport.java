/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaraytracer.raytracer;

/**
 *
 * @author camil
 */
import java.util.Vector;

class Viewport extends Entity {
  public double width;
  public double height;
  public Camera camera;

  public Viewport(Camera camera) {
    // TODO: use focal length
    // position for the viewport center
    super(camera.position.add(camera.direction));

    // TODO: This should come from the FOV angles for vertical and horizontal
    double aspectRatio = (double) camera.imageWidth / (double) camera.imageHeight;

    this.height = 4.0;
    this.width = this.height * aspectRatio;
    this.camera = camera;
  }

  public Vector<Ray> getRays() {
    Vector<Ray> rays = new Vector<>();
    int numHorizontalRays = this.camera.imageWidth;
    int numVerticalRays = this.camera.imageHeight;

    // First ray is in the bottom right of the viewport
    // TODO: these deltas should be orthogonal with the camera direction
    Vector3D deltaU = new Vector3D(this.width / (double) numHorizontalRays, 0, 0);
    Vector3D deltaV = new Vector3D(0, 0, this.height / (double) numVerticalRays);


    for (int i = 0; i < numHorizontalRays; i++) {
      for (int j = 0; j < numVerticalRays; j++) {

        Vector3D rayPosition = new Vector3D(this.position.x - this.width / 2, this.position.y,
                this.position.z - this.height / 2)
                .add(deltaU.multiplyScalar(1.0 / 2.0))
                .add(deltaV.multiplyScalar(1.0 / 2.0))
                .add(deltaU.multiplyScalar(i))
                .add(deltaV.multiplyScalar(j));

        UnitVector3D rayDirection = rayPosition.subtract(this.camera.position).normalize();
        //UnitVector3D rayDirection = camera.direction;

        rays.add(new Ray(rayPosition, rayDirection, i, j));
      }
    }

    return rays;
  }
}