package ru.stqa.pft.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Test", "+79999999", "test@mail.com"));
    app.getGroupHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();

  }

}
