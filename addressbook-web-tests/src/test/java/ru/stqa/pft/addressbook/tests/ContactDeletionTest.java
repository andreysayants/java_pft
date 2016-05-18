package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.Group().All().size() == 0) {
      app.Group().create(new GroupData().withName("test1"));
    }
    app.goTo().ContactPage();
    if (app.Contact().All().size() == 0) {
      app.Contact().create(new ContactData()
              .withFirstname("first1").withAddress("address1").withMobile("89111111111").withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion() {
    app.goTo().ContactPage();
    Contacts before = app.Contact().All();
    ContactData deletedContact = before.iterator().next();
    app.Contact().delete(deletedContact);
    assertThat(app.Contact().Count(), equalTo(before.size() - 1));
    Contacts after = app.Contact().All();

    assertThat(after, equalTo(before.without(deletedContact)));
  }
}

