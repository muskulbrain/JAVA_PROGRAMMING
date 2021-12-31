package ru.stqa.pft.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {

    super(wd);
  }

  public void returnToGroupPage() {

    click(By.linkText("group page"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void submitGroupCreation() {

    click(By.name("submit"));
  }

  public void initGroupCreation() {

    click(By.name("new"));
  }

  public void deleteSelectedGroups() {

    click(By.xpath("//div[@id='content']/form/input[5]"));
  }

  public void selectGroup(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {

    click(By.name("edit"));
  }

  public void submitGroupModification() {

    click(By.name("update"));
  }


  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
