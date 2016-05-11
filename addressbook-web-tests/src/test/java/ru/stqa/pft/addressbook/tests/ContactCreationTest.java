package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    ContactData contact = new ContactData("first1", null, null, "address1", "89111111111", "test1");
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().isThereGroup()) {
      app.getContactHelper().createContact(contact);
    } else {
      app.getGroupHelper().CreateGroup(new GroupData("test1", null, null));
      app.getContactHelper().returnToHomePage();
      app.getContactHelper().createContact(contact);
    }
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
