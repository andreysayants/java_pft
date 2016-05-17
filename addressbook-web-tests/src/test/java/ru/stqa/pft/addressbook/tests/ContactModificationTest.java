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
  public void testContactModification() {
    app.goTo().ContactPage();
        List<ContactData> before = app.Contact().List();
        int index = before.size() - 1;
        ContactData fillingContact = new ContactData()
                .withId(before.get(index).getId()).withFirstname("first3").withLastname("last3").withCompany("company3").withAddress("address3").withMobile("89333333333");
        app.Contact().modify(index, fillingContact);
        List<ContactData> after = app.Contact().List();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(fillingContact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
  }
}

