package Raytracer;

public class Config {
  private final int imageWidth;
  private final double aspectRatio;
  private final int samplesPerPixel;
  private final int maxDepth;
  private int imageHeight;

  public Config(
    int imageWidth, double aspectRatio, int samplesPerPixel, int maxDepth
  ) {
    this.imageWidth = imageWidth;
    this.aspectRatio = aspectRatio;

    imageHeight = (int) (imageWidth / aspectRatio);
    imageHeight = Math.max(imageHeight, 1);

    this.samplesPerPixel = samplesPerPixel;
    this.maxDepth = maxDepth;
  }

  public int getImageWidth() {
    return imageWidth;
  }

  public int getImageHeight() {
    return imageHeight;
  }

  public double getAspectRatio() {
    return aspectRatio;
  }

  public int getSamplesPerPixel() {
    return samplesPerPixel;
  }

  public int getMaxDepth() {
    return maxDepth;
  }
}
