package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModificationTests() {

    app.goTo().homePage();
    if (app.contact().contactList().size () == 0) {
      app.contact(). createContact(new ContactData("Test", null, null, null));
    }

    List<ContactData> before = app.contact().contactList();
    app.contact().initContactModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Test", null, null, null);
    app.contact().fillContactForm(contact);
    app.contact().submitContactModification();
    app.goTo().returnToHomePage();
    List<ContactData> after = app.contact().contactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
