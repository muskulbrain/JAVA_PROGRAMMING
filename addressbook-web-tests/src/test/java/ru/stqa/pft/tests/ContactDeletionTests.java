package ru.stqa.pft.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.tests.TestBase;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion()  {

    app.goToHomePage();
    app.chooseCheckbox();
    app.deleteSelectedContact();
    app.closeTheDialog();
  }

}

