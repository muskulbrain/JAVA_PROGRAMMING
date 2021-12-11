package ru.stqa.pft.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.tests.TestBase;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.goToContactPage();
    app.fillContactForm(new ContactData("Test", "Test", "+79999999", "test@mail.com"));
    app.getGroupHelper().submitContactCreation();
    app.returnToHomePage();

  }

}
