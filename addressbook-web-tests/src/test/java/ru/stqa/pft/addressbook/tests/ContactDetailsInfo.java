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
 * Created by andrey.sayants on 19.05.2016.
 */
public class ContactDetailsInfo extends TestBase {
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
  public void testContactAddressEmails() {
    app.goTo().ContactPage();
    ContactData contact = app.Contact().All().iterator().next();
    ContactData contactInfoFromEditForm = app.Contact().infoFromEditForm(contact);
    ContactData contactInfo = app.Contact().infoFromDetailsForm(contact);

    assertThat(cleaned(contactInfo.getInfo()), equalTo(mergeInfo(contactInfoFromEditForm)));
    assertThat(mergeInfo(contactInfo), equalTo(mergeInfo(contactInfoFromEditForm)));
  }

  private String mergeInfo(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getCompany(), contact.getAddress(),
            contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
            contact.getEmail1(), contact.getEmail2(), contact.getEmail3(), contact.getInfo())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactDetailsInfo::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String clean) {
    return clean.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
