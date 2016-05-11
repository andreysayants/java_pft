package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by andrey.sayants on 26.04.2016.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    ContactData creationContact = new ContactData("first1", null, null, "address1", "89111111111", "test1");
    ContactData fillingContact = new ContactData("first2", "last2", "company2", "address2", "89222222222", null);
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().isThereGroup()) {
      app.getNavigationHelper().gotoContactPage();
      if (!app.getContactHelper().isThereContact()) {
        app.getContactHelper().createContact(creationContact);
        app.getContactHelper().returnToHomePage();
        app.getContactHelper().editContact(0);
        app.getContactHelper().fillContactForm(fillingContact, false);
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().returnToHomePage();
      } else {
        app.getContactHelper().editContact(0);
        app.getContactHelper().fillContactForm(fillingContact, false);
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().returnToHomePage();
      }
    } else {
      app.getGroupHelper().CreateGroup(new GroupData("test1", null, null));
      app.getContactHelper().returnToHomePage();
      if (!app.getContactHelper().isThereContact()) {
        app.getContactHelper().createContact(creationContact);
        app.getContactHelper().returnToHomePage();
        app.getContactHelper().editContact(0);
        app.getContactHelper().fillContactForm(fillingContact, false);
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().returnToHomePage();
      } else {
        app.getContactHelper().editContact(0);
        app.getContactHelper().fillContactForm(fillingContact, false);
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().returnToHomePage();
      }

    }
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}

