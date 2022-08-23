package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {

    app.goTo().groupPage();
    if (app.group().groupList().size () == 0) {
      app.group().Create(new GroupData().withName("Test1"));
    }
    List<GroupData> before = app.group().groupList();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().groupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }


}
