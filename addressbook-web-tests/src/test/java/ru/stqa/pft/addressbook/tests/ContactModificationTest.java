package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by andrey.sayants on 26.04.2016.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().CreateGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("first1", null, null, "address1", "89111111111", "test1"));
    }
  }

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        ContactData fillingContact = new ContactData(before.get(index).getId(),"first3", "last3", "company3", "address3", "89333333333", null);
        app.getContactHelper().modifyContact(index, fillingContact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(fillingContact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
  }
}

