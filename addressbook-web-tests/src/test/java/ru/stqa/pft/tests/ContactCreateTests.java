package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreateTests extends TestBase {

  @Test
  public void testContactCreation() {

    List<ContactData> before = app.contact().contactList();
    ContactData contact = new ContactData().withName("Test").withLastName(null).withPhone(null).withEmail(null);
    app.goTo().contactPage();
    app.contact().createContact(contact);
    List<ContactData> after = app.contact().contactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
