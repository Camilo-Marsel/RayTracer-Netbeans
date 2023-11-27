package Raytracer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RayTracer {

     public static void main(String[] args) {
    // Very unoptimized ray tracer, code is really optimized to be read by humans
    Config config = new Config(1000, 16.0 / 9.0, 100, 50);
    Renderer renderer = new Renderer(config);

    Material materialGround = new LambertianMaterial(new double[]{0.8, 0.8, 0.0});
    Material materialCenter = new LambertianMaterial(new double[]{0.1, 0.2, 0.5});
    Material materialLeft = new LambertianMaterial(new double[]{0.84, 0.06, 0.34});
    Material materialRight = new MetalMaterial(new double[]{0.8, 0.6, 0.2}, 0.0);

    ArrayList<Hittable> objects = new ArrayList<>();

    objects.add(new Sphere(new Vector3D(0.0, -100.5, -1.0), 100.0, materialGround));
    objects.add(new Sphere(new Vector3D(0.0, 0.0, -1.0), 0.5, materialCenter));
    objects.add(new Sphere(new Vector3D(-1.0, 0.0, -1.0), 0.5, materialLeft));
    objects.add(new Sphere(new Vector3D(1.0, 0.0, -1.0), 0.5, materialRight));

    Vector3D lookFrom = new Vector3D(-2, 2, 1);
    Vector3D lookAt = new Vector3D(0, 0, -1);
    Vector3D vUp = new Vector3D(0, 1, 0);

    Camera camera = new Camera(lookFrom, lookAt, vUp, 20, config);
    Scene scene = new Scene(objects, camera);

    BufferedImage renderedImage = renderer.render(scene);

    try {
      ImageIO.write(renderedImage, "PNG", new File("output.png"));
    } catch (IOException e) {
      System.out.println("[ERROR]: Error writing file to disk");
    }

  }
}
