package ru.stqa.pft.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("Test").withLastName(null).withPhone(null).withEmail(null);
    app.goTo().contactPage();
    app.contact().createContact(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testContactBadCreation() {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("Test'").withLastName(null).withPhone(null).withEmail(null);
    app.goTo().contactPage();
    app.contact().createContact(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}