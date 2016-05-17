package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.Group().All().size() == 0) {
      app.Group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testContactCreation() {
    ContactData contact = new ContactData()
            .withFirstname("first1").withLastname("last2").withAddress("address1").withMobile("89111111111").withGroup("test1");
    app.goTo().ContactPage();
    List<ContactData> before = app.Contact().List();
    app.Contact().create(contact);
    List<ContactData> after = app.Contact().List();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
