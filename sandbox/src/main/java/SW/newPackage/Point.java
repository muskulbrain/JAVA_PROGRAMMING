package SW.newPackage;

import java.sql.SQLOutput;

public class Point {

  public static void main(String[] args) {

    PointsData S = new PointsData(2,2,7,6);

    System.out.println("Расстояние между точками = " + S.distance());
    }
}