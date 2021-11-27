package SW.newPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PointTests {

  @Test
    public void testEquality() {

      PointsData S = new PointsData(2,2,7,6);
      assert S.distance() == 6.4031242374328485;

    }

    @Test
    public void testInequality () {

      PointsData S = new PointsData(2,2,7,6);
      assert S.distance() == 10;
    }
    @Test
    public void testInequality1 () {

      PointsData S = new PointsData(2, 2, 7, 6);
      Assert.assertEquals (S.distance()), 10.0;
    }

}
