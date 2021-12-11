package ru.stqa.pft.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    super(wd);

    this.wd = wd;
  }

  public void goToGroupPage() {

    click(By.linkText("groups"));
  }

  public void goToContactPage() {

    wd.findElement(By.linkText("add new")).click();
  }

  public void returnToHomePage() {

    wd.findElement(By.linkText("home page")).click();
  }

  public void goToHomePage() {

    wd.findElement(By.linkText("home")).click();
  }
}
