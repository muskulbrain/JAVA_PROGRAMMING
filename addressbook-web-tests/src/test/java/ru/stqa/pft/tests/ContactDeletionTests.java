package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion()  {

    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper(). createContact(new ContactData("Test", "Test", "+79999999", "test@mail.com"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().chooseCheckbox(before.size() -1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeTheDialog();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() -1);
  }

}

