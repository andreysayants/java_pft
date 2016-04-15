package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by andrey.sayants on 15.04.2016.
 */
public class PointTests {

  @Test
  public void test1Distance() {
    Point p = new Point(1, 2);
    Assert.assertEquals(p.distance(), 2.23606797749979);
  }

  @Test
  public void test2Distance() {
    Point a = new Point(3, 4);
    Assert.assertEquals(a.distance(), 5.0);
  }

  @Test
  public void test3Distance() {
    Point b = new Point(5, 6);
    Assert.assertEquals(b.distance(), 7.810249675906654);
  }
}