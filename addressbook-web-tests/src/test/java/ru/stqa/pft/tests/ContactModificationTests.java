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
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactData()
              .withName("Test").withLastName("Test").withPhone("+79999999").withEmail("test@mail.com"));
    }
  }
    @Test
    public void testContactModificationTests() {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withName("Test").withLastName(null).withPhone(null).withEmail(null);
    app.goTo().homePage();
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withAdded(contact)));
  }



}
