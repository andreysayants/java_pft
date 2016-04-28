package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {

    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().isThereGroup()) {
      app.getNavigationHelper().gotoContactPage();
      if (!app.getContactHelper().isThereContact()) {
        app.getContactHelper().createContact(new ContactData("first1", null, null, "address1", "89111111111", "test1"), true);
        app.getContactHelper().returnToHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().returnToHomePage();
        ;
      } else {
        app.getContactHelper().editContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().returnToHomePage();
      }
    } else {
      app.getGroupHelper().CreateGroup(new GroupData("test1", null, null));
      app.getContactHelper().returnToHomePage();
      if (!app.getContactHelper().isThereContact()) {
        app.getContactHelper().createContact(new ContactData("first1", null, null, "address1", "89111111111", "test1"), true);
        app.getContactHelper().returnToHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().returnToHomePage();
      } else {
        app.getContactHelper().editContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().returnToHomePage();
      }

    }

  }

}
