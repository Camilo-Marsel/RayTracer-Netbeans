package Raytracer;

public interface Hittable {
  // Retorna un HitRecord con la información de donde el rayo interseca el objeto, o `null` si no lo interseca.
  HitRecord hit(Ray ray, Interval tInterval);
}