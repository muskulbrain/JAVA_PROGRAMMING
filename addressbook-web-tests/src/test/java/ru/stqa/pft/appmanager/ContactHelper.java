package ru.stqa.pft.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {

    super (wd);
  }

  public void fillContactForm(ContactData contactData) {

    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("home"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());
  }

  public void closeTheDialog() {

    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {

    click(By.xpath("//input[@value='Delete']"));
  }

  public void chooseCheckbox(int index) {

    wd.findElements(By.xpath("//td/input")).get(index).click();
  }

  public void submitContactCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initContactModification(int index) {

    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {

    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void createContact(ContactData contact) {
    contactPage();
    fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {

    return isElementPresent(By.xpath("//td/input"));
  }

  public int getContactCount() {

    return wd.findElements(By.xpath("//td/input")).size();
  }

  public void delete(int index) {
    chooseCheckbox(index);
    deleteSelectedContact();
    closeTheDialog();
    homePage();
  }

  public List<ContactData> contactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String name = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, name, null, null, null);
      contacts.add(contact);
    }
    return contacts;
    }

  }



