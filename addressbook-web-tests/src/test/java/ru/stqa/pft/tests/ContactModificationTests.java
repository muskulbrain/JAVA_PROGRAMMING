package ru.stqa.pft.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void  ensurePreconditions() {

      if (app.db().contacts().size() == 0) {
        app.goTo().contactPage();
        app.contact().createContact(new ContactData()
                .withName("Test").withLastName("Test").withPhone("+79999999").withEmail("test@mail.com"));
      }
  }
    @Test
    public void testContactModificationTests() {

    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withName("Test").withLastName("+79999999").withPhone(null).withEmail("test@mail.com");
    app.goTo().homePage();
    app.contact().modify(contact);
    //assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withAdded(contact)));
  }



}
