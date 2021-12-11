package ru.stqa.pft.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver wd;
  private ContactHelper contactHelper;
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
    contactHelper = new ContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    logOut("Logout");
    wd.quit();
  }


  public void goToContactPage() {

    wd.findElement(By.linkText("add new")).click();
  }

  public void logOut(String logout) {

    wd.findElement(By.linkText(logout)).click();
  }

  public void returnToHomePage() {

    wd.findElement(By.linkText("home page")).click();
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

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
