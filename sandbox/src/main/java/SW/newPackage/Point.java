package SW.newPackage;

import java.sql.SQLOutput;

public class Point {

  public static void main(String[] args) {

    PointsData S = new PointsData(2,2,7,6);

    System.out.println("Расстояние между точками =" + distance(S));
  }

  public static double distance (PointsData S) {
    return Math.sqrt(Math.pow((S.x2 - S.x1), 2) + Math.pow((S.y2 - S.y1), 2));


  }

}