package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first1", null, null, "address1", "89111111111", "test1"), true);
    }
    app.getContactHelper().editContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().returnToHomePage();
  }

}
