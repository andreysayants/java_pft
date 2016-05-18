package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    if (app.Contact().All().size() == 0) {
      app.Contact().create(new ContactData()
              .withFirstname("first1").withAddress("address1").withMobile("89111111111").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    app.goTo().ContactPage();
    Contacts before = app.Contact().All();
    ContactData modifiedContact = before.iterator().next();
    ContactData Contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("first3").withLastname("last3").withCompany("company3").withAddress("address3").withMobile("89333333333");
    app.Contact().modify(Contact);
    assertThat(app.Contact().Count(), equalTo(before.size()));
    Contacts after = app.Contact().All();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(Contact)));
  }
}

