package ru.stqa.pft.addressbookContacs;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.TestBase;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() {

    goToContactPage();
    fillContactForm(new ContactData("Test", "Test", "+79999999", "test@mail.com"));
    submitContactCreation();
    returnToHomePage();

  }

}
