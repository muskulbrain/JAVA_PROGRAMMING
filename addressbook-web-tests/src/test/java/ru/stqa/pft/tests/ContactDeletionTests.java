package ru.stqa.pft.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.GroupData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion()  {

    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper(). createContact(new ContactData("Test", "Test", "+79999999", "test@mail.com"));
    }
    app.getContactHelper().chooseCheckbox();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeTheDialog();
  }

}

