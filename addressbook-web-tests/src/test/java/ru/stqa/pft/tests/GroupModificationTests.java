package ru.stqa.pft.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.model.GroupData;

public class GroupModificationTests extends TestBase {

@Test
  public void testGroupModificationTests() {

  app.getNavigationHelper().goToGroupPage();
  app.getGroupHelper().selectGroup();
  app.getGroupHelper().initGroupModification();
  app.getGroupHelper().fillGroupForm(new GroupData("Test1", "Test3", "Test2"));
  app.getGroupHelper().submitGroupModification();
}




}
