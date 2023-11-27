package Raytracer;

public class Vector3D {
  private final double x, y, z;

  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public static Vector3D random() {
    return new Vector3D(Math.random(), Math.random(), Math.random());
  }

  public static Vector3D random(double min, double max) {
    return new Vector3D(Math.random() * (max - min) + min, Math.random() * (max - min) + min,
                        Math.random() * (max - min) + min
    );
  }

  // Se hace de esta manera para asegurar una distribución uniforme dentro de la esfera.
  // Ver https://mathworld.wolfram.com/SpherePointPicking.html
  public static Vector3D randomInsideUnitSphere() {
    while (true) {
      Vector3D vector = random(-1, 1);

      if (vector.length() < 1) {
        return vector;
      }
    }
  }

  // Método para obtener un vector en la superficie de una esfera unitaria
  public static UnitVector3D randomUnitVector() {
    return randomInsideUnitSphere().normalize();
  }

  public static UnitVector3D randomInHemisphere(UnitVector3D normal) {
    UnitVector3D onUnitSphere = randomUnitVector();

    if (onUnitSphere.dot(normal) > 0.0) {
      return onUnitSphere;
    } else {
      return onUnitSphere.multiplyScalar(-1).normalize();
    }
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  // Suma de vectores.
  public Vector3D add(Vector3D vector) {
    return new Vector3D(x + vector.x, y + vector.y, z + vector.z);
  }

  // Resta de vectores.
  public Vector3D subtract(Vector3D vector) {
    return this.add(vector.multiplyScalar(-1));
  }

  // Multiplicación por un escalar.
  public Vector3D multiplyScalar(double c) {
    return new Vector3D(x * c, y * c, z * c);
  }

  // Producto escalar entre dos vectores.
  public double dot(Vector3D vector) {
    return x * vector.x + y * vector.y + z * vector.z;
  }

  public Vector3D cross(Vector3D vector) {
    return new Vector3D(y * vector.z - vector.y * z, z * vector.x - vector.z * x,
                        x * vector.y - vector.x * y
    );
  }

  // Convierte el vector en un vector unitario.
  public UnitVector3D normalize() {
    double length = length();
    return new UnitVector3D(x / length, y / length, z / length);
  }

  // Calcula la longitud del vector.
  public double length() {
    return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
  }

  public boolean nearZero() {
    double epsilon = 1e-8;
    return Math.abs(x) < epsilon && Math.abs(y) < epsilon && Math.abs(z) < epsilon;
  }

  public Vector3D reflect(UnitVector3D normal) {
    return subtract(normal.multiplyScalar(2.0 * dot(normal)));
  }
}
