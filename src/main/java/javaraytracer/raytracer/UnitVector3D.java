/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaraytracer.raytracer;

/**
 *
 * @author camil
 */
public class UnitVector3D extends Vector3D {
  public UnitVector3D(double x, double y, double z) {
    super(x, y, z);
    double length = this.length();
    this.x = this.x / length;
    this.y = this.y / length;
    this.z = this.z / length;
  }
}
