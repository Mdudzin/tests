package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.pageobjects.WikiPage;
import com.gitlab.rmarzec.utils.BaseTests;
import org.testng.annotations.Test;

public class Task2Test extends BaseTests {

  @Test
  public void printAllAvailableLanguages() {
    WikiPage wikiPage = new WikiPage(webDriver);
    navigateTo("https://pl.wikipedia.org/wiki/Wiki");
    wikiPage.clickLanguageButton();
    wikiPage.waitForLinks(webDriver);
    wikiPage.printAvailableLanguages();
  }
}
