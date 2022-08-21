package ru.stqa.pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModificationTests() {

    app.goTo().groupPage();
    if (app.group().groupList().size () == 0) {
      app.group().Create(new GroupData("Test1", null, null));
    }

    List<GroupData> before = app.group().groupList();
    app.group().selectGroup(before.size() - 1);
    app.group().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "Test1", null, null);
    app.group().fillGroupForm(group);
    app.group().submitGroupModification();
    app.group().returnToGroupPage();
    List<GroupData> after = app.group().groupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
