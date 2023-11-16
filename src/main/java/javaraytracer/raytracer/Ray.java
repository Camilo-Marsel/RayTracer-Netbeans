
package javaraytracer.raytracer;

/**
 *
 * @author camil
 */
public class Ray extends Entity {
  UnitVector3D direction;
  int pixelX;
  int pixelY;

  public Ray(Vector3D origin, UnitVector3D direction, int pixelX, int pixelY) {
    super(origin);
    this.direction = direction;
    this.pixelX = pixelX;
    this.pixelY = pixelY;
  }

  Ray at(double t) {
    return new Ray(this.position.add(this.direction.multiplyScalar(t)), this.direction, this.pixelX, this.pixelY);
  }

  public String toString() {
    return String.format("Ray[<%f, %f, %f> -> <%f, %f, %f>]", this.position.x, this.position.y, this.position.z,
            this.direction.x, this.direction.y, this.direction.z);
  }
}