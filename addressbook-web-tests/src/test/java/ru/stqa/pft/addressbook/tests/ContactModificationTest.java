package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by andrey.sayants on 26.04.2016.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    ContactData creationContact = new ContactData("first1", null, null, "address1", "89111111111", "test1");
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().isThereGroup()) {
      app.getNavigationHelper().gotoContactPage();
      if (!app.getContactHelper().isThereContact()) {
        app.getContactHelper().createContact(creationContact);
        app.getContactHelper().returnToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData fillingContact1 = new ContactData(before.get(before.size() - 1).getId(),"first2", "last2", "company2", "address2", "89222222222", null);
        app.getContactHelper().editContact(before.size() - 1);
        app.getContactHelper().fillContactForm(fillingContact1, false);
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(fillingContact1);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
      } else {
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData fillingContact2 = new ContactData(before.get(before.size() - 1).getId(),"first2", "last2", "company2", "address2", "89222222222", null);
        app.getContactHelper().editContact(before.size() - 1);
        app.getContactHelper().fillContactForm(fillingContact2, false);
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(fillingContact2);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
      }
    } else {
      app.getGroupHelper().CreateGroup(new GroupData("test1", null, null));
      app.getContactHelper().returnToHomePage();
      if (!app.getContactHelper().isThereContact()) {
        app.getContactHelper().createContact(creationContact);
        app.getContactHelper().returnToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData fillingContact3 = new ContactData(before.get(before.size() - 1).getId(),"first2", "last2", "company2", "address2", "89222222222", null);
        app.getContactHelper().editContact(before.size() - 1);
        app.getContactHelper().fillContactForm(fillingContact3, false);
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(fillingContact3);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
      } else {
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData fillingContact4 = new ContactData(before.get(before.size() - 1).getId(),"first2", "last2", "company2", "address2", "89222222222", null);
        app.getContactHelper().editContact(before.size() - 1);
        app.getContactHelper().fillContactForm(fillingContact4, false);
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(fillingContact4);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
      }

    }
  }
}

