package Raytracer;

public class Entity {
  private Vector3D position;

  public Entity(Vector3D position) {
    this.position = position;
  }

  public Vector3D getPosition() {
    return position;
  }

  public void setPosition(Vector3D position) {
    this.position = position;
  }

  public void setPosition(double x, double y, double z) {
    position = new Vector3D(x, y, z);
  }
}
