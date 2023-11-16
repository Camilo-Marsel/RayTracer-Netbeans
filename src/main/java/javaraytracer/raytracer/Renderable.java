/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaraytracer.raytracer;

/**
 *
 * @author camil
 */
public interface Renderable {
  // Returns the distance between the ray and the hit object, if it does not hit the object, it returns -1
  double isHit(Ray ray);
  UnitVector3D getNormal(Ray ray);
}
