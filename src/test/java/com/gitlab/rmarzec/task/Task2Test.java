package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.pageobjects.WikipediaHomePage;
import com.gitlab.rmarzec.utils.BaseTests;
import org.testng.annotations.Test;

public class Task2Test extends BaseTests {

  @Test
  public void printAllAvailableLanguages() {
    //Inicjalizacja Page Objectów
    WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(webDriver);

    //1. przejście pod adres https://pl.wikipedia.org/wiki/Wiki
    navigateTo("https://pl.wikipedia.org/wiki/Wiki");

    //2. kliknięcie przycisku z listą dostępnych języków
    wikipediaHomePage.clickLanguageButton();

    //3. wypisanie wszystkich dostępnych języków z listy
    wikipediaHomePage.waitForLinks(webDriver);
    wikipediaHomePage.printAvailableLanguages();
  }
}
