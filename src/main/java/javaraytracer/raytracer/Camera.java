
package javaraytracer.raytracer;

public class Camera extends Entity {
  public UnitVector3D direction;
  Viewport viewport;
  public int imageWidth;
  public int imageHeight;

  public Camera(int imageWidth, int imageHeight) {
    // TODO: make this dynamic
    super(new Vector3D(0, 0, 0));
    this.direction = new UnitVector3D(0, -1, 0);
    this.imageWidth = imageWidth;
    this.imageHeight = imageHeight;
    this.viewport = new Viewport(this);
  }
}
