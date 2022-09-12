package ru.stqa.pft.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.Contacts;
import ru.stqa.pft.model.GroupData;
import ru.stqa.pft.model.Groups;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import static org.openqa.selenium.By.name;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {

    super (wd);
  }

  public void fillContactForm(ContactData contactData) {

    type(name("firstname"), contactData.getName());
    type(name("lastname"), contactData.getLastName());
    type(name("home"), contactData.getPhone());
    type(name("email"), contactData.getEmail());
    type(name("address"), contactData.getAddress());
    type(name("home"), contactData.getHomePhone());
    type(name("mobile"), contactData.getMobilePhone());
    type(name("work"), contactData.getWorkPhone());
    type(name("email"), contactData.getEmail());
    type(name("email2"), contactData.getEmail2());
    type(name("email3"), contactData.getEmail3());
    //attach(By.name("photo"), contactData.getPhoto());
  }

  public void closeTheDialog() {

    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {

    click(By.xpath("//input[@value='Delete']"));
  }

  public void submitContactCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initContactModification(int id) {

    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void selectContactById(int id) {
    if (wd.findElement(By.cssSelector("input[value='" + id + "']")).isDisplayed()) {
      wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
  }

  public void submitContactModification() {

    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public boolean isThereAContact() {

    return isElementPresent(By.xpath("//td/input"));
  }

  public int count() {

    return wd.findElements(By.xpath("//td/input")).size();
  }

  public void createContact(ContactData contact) {
    contactPage();
    fillContactForm(contact);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    closeTheDialog();
    contactCache = null;
    homePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification(contact.getId());
    fillContactForm(contact);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void selectContact(Contacts contacts, Groups groups) {
    checkContactInGroup(contacts, groups);
  }

  public void checkContactInGroup(Contacts contacts, Groups groups) {
    int groupsSize = groups.size();
    ContactData contact = сontactCanBeAddedToGroup(contacts, groupsSize);
    GroupData group = groupDoesNotIncludeContact(contacts, groups);
    if (group != null && contact != null) {
      selectContactById(contact.getId());
      selectGroup(group.getId());

      assertThat(contact.inGroup(group), equalTo(group));
    }
  }

  public void deleteContact(Contacts contacts, Groups groups) {
    int groupsSize = groups.size();
    ContactData contact = сontactCanBeAddedToGroup(contacts, groupsSize);
    GroupData group = groupDoesNotIncludeContact(contacts, groups);
    if (group != null && contact != null) {
      chooseGroup(group.getId());
      selectContactById(contact.getId());
      selectGroup(group.getId());
      deleteContactFromGroup(group.getName());

      assertThat(contact.inGroup(group), equalTo(group));
      Assert.assertNotEquals(contact.getGroups(), (group));
    }
  }

  public void chooseGroup(int groupId) {
    new Select(wd.findElement(By.name("group"))).selectByValue(String.valueOf(groupId));
  }

  public ContactData сontactCanBeAddedToGroup(Contacts contacts, int groupSize) {
    for (ContactData contact : contacts) {
      if (contact.getGroups().size() < groupSize) {
        return contact;
      }
    }
    return null;
  }

  public GroupData groupDoesNotIncludeContact(Contacts contact, Groups groups) {
    for (GroupData group : groups) {
      if (group.getContacts().iterator().next().equals(contact)) {
        return group;
      }
    }
    return null; // не нашли
  }

  public void deleteContactFromGroup(String name) {
    click(By.name("update"));
    wd.findElement(By.cssSelector("input[value='Remove from " + name + "']")).click();
  }

  public void selectGroup(int groupId) {
    new Select(wd.findElement(name("to_group"))).selectByValue(String.valueOf(groupId));
    addContactToGroup();
    returnToHomePage();
  }

  public void addContactToGroup() {
    click(name("add"));
  }
  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contactCache.add(new ContactData()
              .withId(id).withName(name).withLastName(null).withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones));

    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String name = wd.findElement(name("firstname")).getAttribute("value");
    String lastname = wd.findElement(name("lastname")).getAttribute("value");
    String home = wd.findElement(name("home")).getAttribute("value");
    String mobile = wd.findElement(name("mobile")).getAttribute("value");
    String work = wd.findElement(name("work")).getAttribute("value");
    String address = wd.findElement(name("address")).getAttribute("value");
    String email = wd.findElement(name("email")).getAttribute("value");
    String email2 = wd.findElement(name("email2")).getAttribute("value");
    String email3 = wd.findElement(name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(null).withLastName(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  private  void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
}



