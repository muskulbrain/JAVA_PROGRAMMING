package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion()  {

    app.goTo().homePage();
    if (app.contact().contactList().size () == 0) {
      app.contact(). createContact(new ContactData("Test", "Test", "+79999999", "test@mail.com"));
    }
    List<ContactData> before = app.contact().contactList();
    int index = before.size() -1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().contactList();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }



}

