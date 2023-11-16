/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaraytracer.raytracer;
public class Sphere extends Entity implements Renderable {
  double radius;

  public Sphere(Vector3D position, double radius) {
    super(position);
    this.radius = radius;
  }

  @Override
  public double isHit(Ray ray) {
    Vector3D raySphereDistance = ray.position.subtract(this.position);
    double a = ray.direction.dot(ray.direction);
    double b = 2.0 * raySphereDistance.dot(ray.direction);
    double c = raySphereDistance.dot(raySphereDistance) - this.radius * this.radius;
    double discriminant = (b * b - 4 * a * c);

    if (discriminant < 0) {
      return -1.0;
    }

    return (-b + Math.sqrt(discriminant)) / (2.0 * a);
  }

  @Override
  public UnitVector3D getNormal(Ray ray) {
    UnitVector3D normalVector = ray.position.subtract(this.position).normalize();
    return normalVector;
  }
}