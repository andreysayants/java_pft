package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData()
            .withFirstname("first3").withLastname("last2").withAddress("address1").withMobilePhone("89111111111").withGroup("test1").withPhoto(photo);
    app.goTo().ContactPage();
    Contacts before = app.Contact().All();
    app.Contact().create(contact);
    assertThat(app.Contact().Count(), equalTo(before.size() + 1));
    Contacts after = app.Contact().All();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

 /* @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());

    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }*/
}
