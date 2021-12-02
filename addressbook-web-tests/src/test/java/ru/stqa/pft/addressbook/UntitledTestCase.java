package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class UntitledTestCase {
  private WebDriver wb;
  private JavascriptExecutor js;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wb = new ChromeDriver();
    wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) wb;
    wb.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  @Test
  public void testUntitled() throws Exception {

    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Test1", "Test3", "Test2"));
    submitGroupCreation();
    returnToGroupPage();

  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    logOut("Logout");
    wb.quit();
  }

  private void returnToGroupPage() {
    wb.findElement(By.linkText("group page")).click();
  }

  private void submitGroupCreation() {
    wb.findElement(By.name("submit")).click();
  }

  private void fillGroupForm(GroupData groupData) {
    wb.findElement(By.name("group_name")).click();
    wb.findElement(By.name("group_name")).clear();
    wb.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wb.findElement(By.name("group_header")).click();
    wb.findElement(By.name("group_header")).clear();
    wb.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wb.findElement(By.name("group_footer")).click();
    wb.findElement(By.name("group_footer")).clear();
    wb.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void initGroupCreation() {
    wb.findElement(By.name("new")).click();
  }


  private void goToGroupPage() {
    wb.findElement(By.linkText("groups")).click();
  }

  private void login(String username, String password) {
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys(username);
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys(password);
    wb.findElement(By.xpath("//input[@value='Login']")).click();
  }

  private void logOut(String logout) {
    wb.findElement(By.linkText(logout)).click();
  }

  private boolean isElementPresent(By by) {
    try {
      wb.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
