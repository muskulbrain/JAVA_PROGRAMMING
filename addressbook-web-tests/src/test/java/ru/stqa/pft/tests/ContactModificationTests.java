package ru.stqa.pft.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
    public void testContactModificationTests() {

    app.getContactHelper().goToHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Test", "+79999999", "test@mail.com"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
  }



}
