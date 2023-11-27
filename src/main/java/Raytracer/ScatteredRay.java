package Raytracer;

// Modela un rayo dispersado por la interacción con el material de un objeto material.
public class ScatteredRay extends Ray {
  private final double[] attenuation;

  ScatteredRay(Vector3D position, UnitVector3D direction, double[] attenuation) {
    super(position, direction);
    this.attenuation = attenuation;
  }

  public double[] getAttenuation() {
    return attenuation;
  }
}
