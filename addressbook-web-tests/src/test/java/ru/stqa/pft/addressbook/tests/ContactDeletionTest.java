package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().editContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().returnToHomePage();
  }

}
