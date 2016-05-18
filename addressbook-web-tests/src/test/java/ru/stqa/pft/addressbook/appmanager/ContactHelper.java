package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by andrey.sayants on 26.04.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    if (isElementPresent(By.name("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void editContactById(int id) {
    wd.findElement(By.xpath("//input[@value='" + id + "']/../../td[8]/a")).click();
  }

  public void editSelectedContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData, true);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData Contact) {
    editContactById(Contact.getId());
    fillContactForm(Contact, false);
    editSelectedContact();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData Contact) {
    editContactById(Contact.getId());
    deleteSelectedContact();
    contactCache = null;
    returnToHomePage();
  }

  public boolean isThereContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts All() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
    }
    return new Contacts(contactCache);
  }
}
