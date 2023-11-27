package Raytracer;

public class Interval {
  private final double min;
  private final double max;

  public Interval(double min, double max) {
    this.min = min;
    this.max = max;
  }

  public double getMin() {
    return min;
  }

  public double getMax() {
    return max;
  }

  public double clamp(double value) {
    if (value < min) {
      return min;
    }

    if (value > max) {
      return max;
    }

    return value;
  }

  public boolean surrounds(double value) {
    return min < value && value < max;
  }
}
