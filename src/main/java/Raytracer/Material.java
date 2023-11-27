package Raytracer;

public interface Material {
  ScatteredRay scatter(Ray incidentRay, HitRecord hitRecord);
}
