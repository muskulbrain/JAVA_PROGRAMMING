package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
  public void  ensurePreconditions() {
      app.goTo().homePage();
      if (app.contact().contactList().size() == 0) {
        app.contact().createContact(new ContactData()
                .withName("Test").withLastName("Test").withPhone("+79999999").withEmail("test@mail.com"));
      }
    }

      @Test
     public void testContactModification () {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }



}

