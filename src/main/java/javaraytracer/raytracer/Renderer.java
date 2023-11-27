/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaraytracer.raytracer;

/**
 *
 * @author camil
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Renderer {
  public BufferedImage render(Scene scene) {
    int imageWidth = scene.camera.imageWidth;
    int imageHeight = scene.camera.imageHeight;
//    int InicialX1;
//    int InicialX2;
//    int InicialX3;
//    int InicialY1;
//    int InicialY2;
//    int InicialY3;
//    int InicialZ1;
//    int InicialZ2;
//    int InicialZ3;
//    int InicialR1;
//    int InicialR2;
//    int InicialR3;

    BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

    Vector<Ray> rays = scene.camera.viewport.getRays();

    Color ENVIRONMENT_COLOR = new Color(0, 0, 0);

    for (Ray ray : rays) {
      if (scene.objects.isEmpty()) {
        image.setRGB(ray.pixelX, ray.pixelY, ENVIRONMENT_COLOR.getRGB());
        continue;
      }
      double closestT = Double.POSITIVE_INFINITY;
      Sphere closestSphere = null;
      for (Sphere sphere : scene.objects) {
        double t = sphere.isHit(ray);
        if (t < 0) {
          image.setRGB(ray.pixelX, ray.pixelY, ENVIRONMENT_COLOR.getRGB());
          continue;
        }
        if (t < closestT) {
          closestT = t;
          closestSphere = sphere;
        }

      }
      if (closestSphere != null) {


        UnitVector3D normalVector = closestSphere.getNormal(ray.at(closestT));
        int red = (int) (255.0 * 0.5 * (normalVector.x + 1.0));
        int green = (int) (255.0 * 0.5 * (normalVector.y + 1.0));
        int blue = (int) (255.0 * 0.5 * (normalVector.z + 1.0));
        Color color = new Color(red, green, blue);
        image.setRGB(ray.pixelX, ray.pixelY, color.getRGB());
      }
      //image.setRGB(ray.pixelX, ray.pixelY, ray.getColor(sphere).getRGB());
    }

    return image;
  }

  public Scene getSampleScene() {
    Vector<Sphere> orbs = new Vector<>();

    orbs.add(new Sphere(new Vector3D(1, -2, 1), 0.5));
    orbs.add(new Sphere(new Vector3D(-1, 0, -1), 1.2));
    orbs.add(new Sphere(new Vector3D(0, -2, 0), 0.2));

    return new Scene(orbs, new Camera(720, 650));
  }
  public Scene getUpdateScene(double v1x, double v1y, double v1z, double v1r, double v2x, double v2y, double v2z, double v2r, double v3x, double v3y, double v3z, double v3r) {
    Vector<Sphere> orbs = new Vector<>();

    orbs.add(new Sphere(new Vector3D(v1x, v1y, v1z), v1r));
    orbs.add(new Sphere(new Vector3D(v2x, v2y, v2z), v2r));
    orbs.add(new Sphere(new Vector3D(v3x, v3y, v3z), v3r));

    return new Scene(orbs, new Camera(720, 650));
  }
  public Scene getUpdateScene(double v1x, double v1y, double v1z, double v1r, double v2x, double v2y, double v2z, double v2r, double v3x, double v3y, double v3z, double v3r, int vectorX, int vectorY, int vectorZ) {
    Vector<Sphere> orbs = new Vector<>();

    orbs.add(new Sphere(new Vector3D(v1x, v1y, v1z), v1r));
    orbs.add(new Sphere(new Vector3D(v2x, v2y, v2z), v2r));
    orbs.add(new Sphere(new Vector3D(v3x, v3y, v3z), v3r));

    return new Scene(orbs, new Camera(720, 650, vectorX, vectorY, vectorZ));
  }
  
}
