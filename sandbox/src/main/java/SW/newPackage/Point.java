package SW.newPackage;

import java.sql.SQLOutput;

public class Point {

  public static void main(String[] args) {

    NewPoint S = new NewPoint(2,2,7,6);

    System.out.println("Расстояние между точками =" + distance(S));
  }

  public static double distance (NewPoint S) {
    return Math.sqrt(Math.pow((S.x2 - S.x1), 2) + Math.pow((S.y2 - S.y1), 2));


  }

}