package SW.newPackage;

public class PointsData {
  public double x;
  public double y;

  public PointsData(double x, double y) {
    this.x = x;
    this.y = y;

  }

  public double distance(PointsData p) {
    return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
  }
}


