package Raytracer;

public class Ray extends Entity {
  private final UnitVector3D direction;

  public Ray(Vector3D origin, UnitVector3D direction) {
    super(origin);
    this.direction = direction;
  }

  public UnitVector3D getDirection() {
    return direction;
  }

  Ray at(double t) {
    return new Ray(getPosition().add(direction.multiplyScalar(t)), direction);
  }
}
