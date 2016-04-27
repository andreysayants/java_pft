package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by andrey.sayants on 26.04.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
}
