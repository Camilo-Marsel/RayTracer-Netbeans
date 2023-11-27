package Raytracer;

public class HitRecord {
  private final double t; // Distancia desde el origen del rayo hasta el punto de intersección.
  private final Vector3D position; // Posición donde el rayo interseca el objeto.
  private final UnitVector3D normal; // Normal del objeto en el punto de intersección.(Siempre apunta hacia afuera del objeto aunque impacte la cara interna.)

  private final boolean frontFace; // Indica si el rayo impactó la cara interna del objeto.
  private final Material material;

  public HitRecord(double t, Ray ray, UnitVector3D outwardNormal, Material material) {
    this.t = t;
    position = ray.at(t).getPosition();
    frontFace = ray.getDirection().dot(outwardNormal) < 0;
    normal = frontFace ? outwardNormal : outwardNormal.multiplyScalar(-1).normalize();
    this.material = material;
  }

  public Vector3D getPosition() {
    return position;
  }

  public UnitVector3D getNormal() {
    return normal;
  }

  public double getT() {
    return t;
  }

  public boolean getFrontFace() {
    return frontFace;
  }

  public Material getMaterial() {
    return material;
  }
}