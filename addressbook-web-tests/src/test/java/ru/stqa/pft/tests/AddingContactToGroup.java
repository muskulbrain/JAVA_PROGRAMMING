package ru.stqa.pft.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.Contacts;
import ru.stqa.pft.model.GroupData;
import ru.stqa.pft.model.Groups;


public class AddingContactToGroup extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactPage();
            app.contact().createContact(new ContactData().withName("test_1"));
            app.contact().createContact(new ContactData().withName("test_2"));
            app.contact().createContact(new ContactData().withName("test_3"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
            app.group().create(new GroupData().withName("test2"));
            app.group().create(new GroupData().withName("test3"));
        }
    }

    @Test
    public void testContactAdditionToGroup() {
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        app.goTo().contactPage();
        app.contact().selectContact(contacts, groups);
        app.contact().deleteContact(contacts, groups);
    }
}
