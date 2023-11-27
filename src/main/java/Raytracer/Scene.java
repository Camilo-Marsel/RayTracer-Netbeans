package Raytracer;

import java.util.ArrayList;

public class Scene implements Hittable {
  private final Camera camera;
  private final ArrayList<Hittable> objects;


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
