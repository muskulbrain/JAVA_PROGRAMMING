package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.GroupData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion()  {

    app.goTo().homePage();
    if (app.contact().contactList().size () == 0) {
      app.contact(). createContact(new ContactData()
              .withName("Test").withLastName("Test").withPhone("+79999999").withEmail("test@mail.com"));
    }
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }



}

