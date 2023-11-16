/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaraytracer.raytracer;
import java.util.Vector;

public class Scene {
  public Vector<Sphere> objects;
  public Camera camera;

  public Scene(Vector<Sphere> objects, Camera camera) {
    this.objects = objects;
    this.camera = camera;
  }
}
