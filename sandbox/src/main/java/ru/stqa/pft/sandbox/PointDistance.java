package ru.stqa.pft.sandbox;

/**
 * Created by andrey.sayants on 15.04.2016.
 */
public class PointDistance {
  public static void main(String[] args) {
    Point first = new Point(2, 3);
    Point second = new Point(4, 5);
    System.out.println("Расстояние между двумя точками " + first.x + "," + first.y + " и " + second.x + ","+ second.y + " = " + first.distance(second));
  }

}
