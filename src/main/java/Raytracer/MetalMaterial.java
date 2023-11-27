package Raytracer;

public class MetalMaterial implements Material {
  private final double[] albedo;
  private final double fuzz;

  public MetalMaterial(double[] albedo, double fuzz) {
    this.albedo = albedo;
    this.fuzz = fuzz < 1 ? fuzz : 1;
  }

  @Override
  public ScatteredRay scatter(Ray ray, HitRecord hitRecord) {
    Vector3D reflectedDirection = ray.getDirection().reflect(hitRecord.getNormal()).normalize();
    Vector3D fuzzDeviation = Vector3D.randomUnitVector().multiplyScalar(fuzz);
    return new ScatteredRay(
      hitRecord.getPosition(), reflectedDirection.add(fuzzDeviation).normalize(), albedo);
  }
}
