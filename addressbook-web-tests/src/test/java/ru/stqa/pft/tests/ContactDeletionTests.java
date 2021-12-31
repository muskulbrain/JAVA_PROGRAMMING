package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.GroupData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion()  {

    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper(). createContact(new ContactData("Test", "Test", "+79999999", "test@mail.com"));
    }
    app.getContactHelper().chooseCheckbox(before - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeTheDialog();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }

}

