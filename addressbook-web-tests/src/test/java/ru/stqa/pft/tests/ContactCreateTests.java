package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() {

    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().createContact(new ContactData("Test", "Test", "+79999999", "test@mail.com"));
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }

}
