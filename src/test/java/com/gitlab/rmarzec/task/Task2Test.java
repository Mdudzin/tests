package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.pageobjects.WikiPage;
import com.gitlab.rmarzec.utils.BaseTests;
import org.testng.annotations.Test;

public class Task2Test extends BaseTests {

  private final String wikiUrl = "https://pl.wikipedia.org/wiki/Wiki";

  @Test
  public void printAllAvailableLanguages() {
    WikiPage wikiPage = new WikiPage(webDriver);
    navigateTo(wikiUrl);
    wikiPage.clickLanguageButton();
    wikiPage.printAvailableLanguages();
  }
}
