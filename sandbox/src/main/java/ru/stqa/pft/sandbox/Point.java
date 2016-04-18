package ru.stqa.pft.sandbox;

/**
 * Created by andrey.sayants on 15.04.2016.
 */
public class Point {
  double x;
  double y;

  public Point(double p1, double p2) {
    this.x = p1;
    this.y = p2;
  }

  public double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }

}
// test First-lesson checkout