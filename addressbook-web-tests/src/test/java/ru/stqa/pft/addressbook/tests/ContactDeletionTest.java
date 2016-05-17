package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.Group().All().size() == 0) {
      app.Group().create(new GroupData().withName("test1"));
    }
    app.goTo().ContactPage();
    if (app.Contact().List().size() == 0) {
      app.Contact().create(new ContactData()
              .withFirstname("first1").withAddress("address1").withMobile("89111111111").withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion() {
    app.goTo().ContactPage();
    List<ContactData> before = app.Contact().List();
    int index = before.size() - 1;
    app.Contact().delete(index);
    List<ContactData> after = app.Contact().List();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}

