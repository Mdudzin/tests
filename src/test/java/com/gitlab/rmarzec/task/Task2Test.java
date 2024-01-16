package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.pageobjects.WikiPage;
import com.gitlab.rmarzec.utils.BaseTests;
import org.testng.annotations.Test;

public class Task2Test extends BaseTests {

  @Test
  public void printAllAvailableLanguages() {
    //Inicjalizacja Page Objectów
    WikiPage wikiPage = new WikiPage(webDriver);

    //1. przejście pod adres https://pl.wikipedia.org/wiki/Wiki
    navigateTo("https://pl.wikipedia.org/wiki/Wiki");

    //2. kliknięcie przycisku z listą dostępnych języków
    wikiPage.clickLanguageButton();

    //3. wypisanie wszystkich dostępnych języków z listy
    wikiPage.waitForLinks(webDriver);
    wikiPage.printAvailableLanguages();
  }
}
