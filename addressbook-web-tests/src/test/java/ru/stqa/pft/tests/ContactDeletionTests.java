package ru.stqa.pft.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion()  {

    app.goToHomePage();
    app.getContactHelper().chooseCheckbox();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeTheDialog();
  }

}

