package SW.newPackage;

import java.sql.SQLOutput;

public class Point {

  public static void main(String[] args) {

    NewPoint S = new NewPoint(2,2,7,6);

    System.out.println("Расстояние между точками = " + S.distance());
  }

}