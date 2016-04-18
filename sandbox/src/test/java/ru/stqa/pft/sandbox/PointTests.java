package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by andrey.sayants on 15.04.2016.
 */
public class PointTests {

  @Test
  public void test1Distance() {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(4, 5);
    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);
  }

  @Test
  public void test2Distance() {
    Point a1 = new Point(3, 4);
    Point a2 = new Point(2, 3);
    Assert.assertEquals(a1.distance(a2), 1.4142135623730951);
  }

  @Test
  public void test3Distance() {
    Point b1 = new Point(5, 6);
    Point b2 = new Point(1, 3);
    Assert.assertEquals(b1.distance(b2), 5.0);
  }
}