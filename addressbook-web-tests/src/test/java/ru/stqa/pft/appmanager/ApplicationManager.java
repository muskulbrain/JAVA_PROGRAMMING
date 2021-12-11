package ru.stqa.pft.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbookContacs.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver wd;

  private SessionHelper sessionHelper;

  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  public JavascriptExecutor js;

  public void init() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) wd;
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    logOut("Logout");
    wd.quit();
  }

  public void submitGroupCreation() {

    wd.findElement(By.name("submit")).click();
  }

  public void goToContactPage() {

    wd.findElement(By.linkText("add new")).click();
  }

  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactData.getPhone());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  public void logOut(String logout) {
    wd.findElement(By.linkText(logout)).click();
  }

  public void returnToHomePage() {

    wd.findElement(By.linkText("home page")).click();
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void closeTheDialog() {

    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {

    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }

  public void chooseCheckbox() {

    wd.findElement(By.xpath("//td/input")).click();
  }

  public void goToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
