package Raytracer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer {
  private final Config config;

  Renderer(Config config) {
    this.config = config;
  }

  private double[] getRayColor(Ray ray, int depth, Scene scene) {
    HitRecord hitRecord = scene.hit(ray, new Interval(0.001, Double.POSITIVE_INFINITY));

    if (depth <= 0) {
      return new double[]{0.0, 0.0, 0.0};
    }

    if (hitRecord != null) {
      if (hitRecord.getT() > 0.0) {
        ScatteredRay scatteredRay = hitRecord.getMaterial().scatter(ray, hitRecord);

        if (scatteredRay != null) {
          double[] bounceColorSample = getRayColor(scatteredRay, depth - 1, scene);
          double[] attenuation = scatteredRay.getAttenuation();
          return new double[]{attenuation[0] * bounceColorSample[0], attenuation[1] * bounceColorSample[1], attenuation[2] * bounceColorSample[2]};
        }

        return new double[]{0.0, 0.0, 0.0};
      }
    }

    return getSkyboxColor(ray);
  }

  private double linearToGamma(double linear) {
    return Math.sqrt(linear);
  }

  private Color getSampledColor(double[] colorSamplesSum, int samplesPerPixel) {
    Interval intensity = new Interval(0.0, 0.999);

    double red = linearToGamma(colorSamplesSum[0] / (double) samplesPerPixel);
    double green = linearToGamma(colorSamplesSum[1] / (double) samplesPerPixel);
    double blue = linearToGamma(colorSamplesSum[2] / (double) samplesPerPixel);

    return new Color((int) (256.0 * intensity.clamp(red)), (int) (255.0 * intensity.clamp(green)),
                     (int) (256.0 * intensity.clamp(blue))
    );
  }

  private double[] getSkyboxColor(Ray ray) {
    Vector3D unitDirection = ray.getDirection().normalize();
    double a = 0.5 * (unitDirection.getY() + 1.0);

    double red = (1.0 - a + 0.5 * a);
    double green = (1.0 - a + 0.7 * a);
    double blue = (1.0 - a + a);

    return new double[]{red, green, blue};
  }

  public BufferedImage render(Scene scene) {
    BufferedImage image = new BufferedImage(
      config.getImageWidth(), config.getImageHeight(), BufferedImage.TYPE_INT_RGB);

    for (int j = 0; j < config.getImageHeight(); j++) {
      for (int i = 0; i < config.getImageWidth(); i++) {

        double[] colorSamplesSum = {0.0, 0.0, 0.0};

        for (int sample = 0; sample < config.getSamplesPerPixel(); sample++) {
          Ray ray = scene.getCamera().getRay(i, j);
          double[] colorSample = getRayColor(ray, config.getMaxDepth(), scene);

          colorSamplesSum[0] += colorSample[0];
          colorSamplesSum[1] += colorSample[1];
          colorSamplesSum[2] += colorSample[2];
        }

        Color color = getSampledColor(colorSamplesSum, config.getSamplesPerPixel());
        image.setRGB(i, j, color.getRGB());
      }
    }

    return image;
  }
}
