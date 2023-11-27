package Raytracer;

public class Sphere extends Entity implements Hittable {
  private final double radius;
  private final Material material;

  public Sphere(Vector3D position, double radius, Material material) {
    super(position);
    this.radius = radius;
    this.material = material;
  }

  // Retorna un HitRecord con la información de donde el rayo interseca el objeto, o `null` si no lo interseca.
  @Override
  public HitRecord hit(Ray ray, Interval tInterval) {
    Vector3D raySphereDistance = ray.getPosition().subtract(getPosition());
    double a = ray.getDirection().dot(ray.getDirection());
    double halfB = raySphereDistance.dot(ray.getDirection());
    double c = raySphereDistance.dot(raySphereDistance) - radius * radius;

    double discriminant = halfB * halfB - a * c;

    if (discriminant < 0) {
      return null;
    }

    double discriminantSqrt = Math.sqrt(discriminant);
    double root = (-halfB - discriminantSqrt) / a;

    if (!tInterval.surrounds(root)) {
      // Verificar la otra raíz de la ecuación cuadrática.
      root = (-halfB + discriminantSqrt) / a;
      if (!tInterval.surrounds(root)) {
        return null;
      }
    }

    double t = root;
    Vector3D position = ray.at(t).getPosition();
    UnitVector3D normal = position.subtract(getPosition()).normalize();

    return new HitRecord(t, ray, normal, material);
  }
}
