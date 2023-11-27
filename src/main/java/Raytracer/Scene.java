package Raytracer;

import java.util.ArrayList;

public class Scene implements Hittable {
  private final Camera camera;
  private final ArrayList<Hittable> objects;
  
  public static Scene getSampleScene(Config config) {
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
        
        return scene;
  }


  public Scene(ArrayList<Hittable> objects, Camera camera) {
    this.objects = objects;
    this.camera = camera;
  }

  public Camera getCamera() {
    return camera;
  }

  public ArrayList<Hittable> getObjects() {
    return objects;
  }

  public void add(Hittable object) {
    objects.add(object);
  }

  // Retorna un HitRecord con la información de donde el rayo interseca al objeto más cercano
  // de la lista de objetos o `null` si no interseca ningún objeto.
  @Override
  public HitRecord hit(Ray ray, Interval tInterval) {
    HitRecord closesHitRecord = null;
    double closestTSoFar = tInterval.getMax();

    for (Hittable hittable : objects) {
      HitRecord hitRecord = hittable.hit(ray, new Interval(tInterval.getMin(), closestTSoFar));
      if (hitRecord != null) {
        closestTSoFar = hitRecord.getT();
        closesHitRecord = hitRecord;
      }
    }

    return closesHitRecord;
  }
}
