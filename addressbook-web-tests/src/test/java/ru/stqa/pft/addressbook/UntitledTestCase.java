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
  }

  @Test
  public void testUntitled() throws Exception {
    wb.get("http://localhost/addressbook/group.php");
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys("admin");
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys("secret");
    wb.findElement(By.xpath("//input[@value='Login']")).click();
    wb.findElement(By.linkText("groups")).click();
    wb.findElement(By.name("new")).click();
    wb.findElement(By.name("group_name")).click();
    wb.findElement(By.name("group_name")).clear();
    wb.findElement(By.name("group_name")).sendKeys("Test1");
    wb.findElement(By.name("group_header")).click();
    wb.findElement(By.name("group_header")).clear();
    wb.findElement(By.name("group_header")).sendKeys("Test2");
    wb.findElement(By.name("group_footer")).click();
    wb.findElement(By.name("group_footer")).clear();
    wb.findElement(By.name("group_footer")).sendKeys("Test3");
    wb.findElement(By.name("submit")).click();
    wb.findElement(By.linkText("group page")).click();
    wb.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wb.quit();
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