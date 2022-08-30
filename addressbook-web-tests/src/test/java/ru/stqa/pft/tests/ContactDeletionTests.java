package ru.stqa.pft.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
  public void  ensurePreconditions() {
      app.goTo().homePage();
      if (app.contact().all().size() == 0) {
        app.contact().createContact(new ContactData()
                .withName("Test").withLastName("Test").withPhone("+79999999").withEmail("test@mail.com"));
      }
    }

      @Test
     public void testContactModification () {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }



}

