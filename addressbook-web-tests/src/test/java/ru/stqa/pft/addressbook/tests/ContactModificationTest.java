package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by andrey.sayants on 26.04.2016.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification () {
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("first2", "last2", "company2", "address2", "89222222222", null), false);
    app.getContactHelper().editSelectedContact();
    app.getContactHelper().returnToHomePage();
  }

}
