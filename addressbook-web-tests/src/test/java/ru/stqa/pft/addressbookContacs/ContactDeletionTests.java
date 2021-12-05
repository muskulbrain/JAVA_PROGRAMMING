package ru.stqa.pft.addressbookContacs;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.TestBase;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion()  {

    goToHomePage();
    chooseCheckbox();
    deleteSelectedContact();
    closeTheDialog();
  }

}

