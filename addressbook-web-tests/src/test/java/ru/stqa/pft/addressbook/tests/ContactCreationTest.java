package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("first1", "last1", "company1", "address1", "89111111111"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}
