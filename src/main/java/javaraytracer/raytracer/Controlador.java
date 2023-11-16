/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaraytracer.raytracer;

import java.util.Vector;

/**
 *
 * @author camil
 */
public class Controlador {
    
    public Scene getUpdateScene(int v1x, int v1y, int v1z, double v1r, int v2x, int v2y, int v2z, double v2r, int v3x, int v3y, int v3z, double v3r) {
    Vector<Sphere> orbs = new Vector<>();

    orbs.add(new Sphere(new Vector3D(v1x, v1y, v1z), v1r));
    orbs.add(new Sphere(new Vector3D(v2x, v2y, v2z), v2r));
    orbs.add(new Sphere(new Vector3D(v3x, v3y, v3z), v3r));

    return new Scene(orbs, new Camera(720, 650));
  }
    
}
