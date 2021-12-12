package ru.stqa.pft.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.model.ContactData;

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

  public void chooseCheckbox() {

    click(By.xpath("//td/input"));
  }

  //private void clickContact(By locator) {
    //wd.findElement(locator).click();
 // }

  //private void typeContact(By locatorContact, String textContact) {
  // click(locatorContact);
  // wd.findElement(locatorContact).clear();
  //wd.findElement(locatorContact).sendKeys(textContact);
  //}
}
