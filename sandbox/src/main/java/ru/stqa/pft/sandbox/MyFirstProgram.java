package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Andrey");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь треугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p = new Point(2, 3);
    System.out.println("Расстояние между двумя точками " + p.p1 + " и " + p.p2 + " = " + p.distance());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


}