package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by andrey.sayants on 18.05.2016.
 */
public class ContactPhoneTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.Group().All().size() == 0) {
      app.Group().create(new GroupData().withName("test1"));
    }
    app.goTo().ContactPage();
    if (app.Contact().All().size() == 0) {
      app.Contact().create(new ContactData()
              .withFirstname("first1").withAddress("address1").withMobilePhone("89111111111").withGroup("test1"));
    }
  }

  @Test
  public void testContactPhone() {
    app.goTo().ContactPage();
    ContactData contact = app.Contact().All().iterator().next();
    ContactData contactInfoFromEditForm = app.Contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhone(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
   return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
           .map(ContactPhoneTest::cleaned)
           .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
