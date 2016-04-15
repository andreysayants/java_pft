package ru.stqa.pft.sandbox;

/**
 * Created by andrey.sayants on 15.04.2016.
 */
public class Point {
  double p1;
  double p2;

  public Point(double p1, double p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public double distance() {
    return Math.sqrt(p1 * p1 + p2 * p2);
  }

}
