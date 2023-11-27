package Raytracer;

public class UnitVector3D extends Vector3D {

  // este constructor no debería ser usado, en vez de esto usar Vector3D.normalize();
  public UnitVector3D(double x, double y, double z) {
    super(x, y, z);
  }
}
