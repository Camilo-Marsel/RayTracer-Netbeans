/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package javaraytracer.raytracer;
import javaraytracer.RayTracerUI.Materiales;
import javaraytracer.RayTracerUI.RayTracerUI;
/**
 *
 * @author camil
 */
public class RayTracer {

    public static void main(String[] args) {
        //Very unoptimized ray tracer, code is really optimized to be read by humans
        Renderer renderer = new Renderer();
        System.out.println("Hello World!");
        RayTracerUI ui = new RayTracerUI(renderer);
        
        ui.setVisible(true);
    }
}
