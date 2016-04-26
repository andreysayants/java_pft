package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("first1", "last1", "company1", "address1", "89111111111"));
    submitContactCreation();
    returnToHomePage();
  }

}
