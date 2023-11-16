
package javaraytracer.raytracer;

/**
 *
 * @author camil
 */
public class Vector3D {
  public double x, y, z;

  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Vector3D add(Vector3D vector) {
    return new Vector3D(this.x + vector.x, this.y + vector.y, this.z + vector.z);
  }

  public Vector3D subtract(Vector3D vector) {
    return this.add(vector.multiplyScalar(-1));
  }

  public Vector3D multiplyScalar(double c) {
    return new Vector3D(this.x * c, this.y * c, this.z * c);
  }

  public double dot(Vector3D vector) {
    return this.x * vector.x + this.y * vector.y + this.z * vector.z;
  }

  public UnitVector3D normalize() {
    return new UnitVector3D(this.x, this.y, this.z);
  }

  public double length() {
    return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
  }
}
