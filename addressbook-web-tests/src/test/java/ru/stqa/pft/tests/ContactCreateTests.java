package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() {

    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withName("Test").withLastName(null).withPhone(null).withEmail(null);
    app.goTo().contactPage();
    app.contact().createContact(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }

}
