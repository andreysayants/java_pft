package ru.stqa.pft.sandbox;

/**
 * Created by andrey.sayants on 27.04.2016.
 */
public class Equality {

  public static void main(String[] args){
    String s1 = "firefox";
    //String s2 = s1; сравнение двух ссылок на объект
    String s2 = new String(s1); // сравнение содержимого двух объектов

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
