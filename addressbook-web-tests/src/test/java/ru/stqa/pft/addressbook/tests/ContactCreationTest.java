package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("first1", null, null, "address1", "89111111111", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }

}
