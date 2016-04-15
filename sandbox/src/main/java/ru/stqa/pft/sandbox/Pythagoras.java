package ru.stqa.pft.sandbox;

/**
 * Created by andrey.sayants on 15.04.2016.
 */
public class Pythagoras {
  public static void main(String[] args) {
    Point p = new Point(2, 3);
    System.out.println("Расстояние между двумя точками " + p.p1 + " и " + p.p2 + " = " + p.distance());
  }

}
