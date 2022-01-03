package ru.stqa.pft.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.model.ContactData;
import ru.stqa.pft.model.GroupData;

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
    goToContactPage();
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

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, name, null, null, null);
      contacts.add(contact);
    }
    return contacts;
    }

  }


  //private void clickContact(By locator) {
    //wd.findElement(locator).click();
 // }

  //private void typeContact(By locatorContact, String textContact) {
  // click(locatorContact);
  // wd.findElement(locatorContact).clear();
  //wd.findElement(locatorContact).sendKeys(textContact);
  //}

