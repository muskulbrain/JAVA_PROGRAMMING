package SW.newPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void distance() {
    PointsData p1 = new PointsData(4, 5);
    PointsData p2 = new PointsData(2, 3);
    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);
  }

  @Test
  public void distance2() {
    PointsData p1 = new PointsData(6, 7);
    PointsData p2 = new PointsData(9, 10);
    Assert.assertEquals(p1.distance(p2), 4.242640687119285);
  }
}
