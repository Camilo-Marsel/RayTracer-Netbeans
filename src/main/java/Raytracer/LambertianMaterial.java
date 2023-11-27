package Raytracer;

public class LambertianMaterial implements Material {
  private final double[] albedo;

  public LambertianMaterial(double[] albedo) {
    this.albedo = albedo;
  }

  @Override
  public ScatteredRay scatter(
    Ray incidentRay, HitRecord hitRecord
  ) {
    UnitVector3D scatteredDirection = hitRecord.getNormal()
                                               .add(Vector3D.randomUnitVector())
                                               .normalize();

    if (scatteredDirection.nearZero()) {
      scatteredDirection = hitRecord.getNormal();
    }

    return new ScatteredRay(hitRecord.getPosition(), scatteredDirection, albedo);
  }
}
