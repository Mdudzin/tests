package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.utils.BaseTests;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task2Test extends BaseTests {

  @Test
  //wersja bez refaktoru
  public void printAllAvailableLanguages() {
    webDriver.get("https://pl.wikipedia.org/wiki/Wiki");
    webDriver.findElement(By.id("p-lang-btn-checkbox")).click();
    List<WebElement> languages = webDriver.findElements(By.cssSelector("a[class='autonym']"));

    for (WebElement language : languages) {
      String languageName = language.getText();
      String languageURL = language.getDomAttribute("href");

      if (languageName.equals("English")) {
        System.out.println(languageName + " (" + languageURL + ")");
      } else {
        System.out.println(languageName);
      }
    }
  }

  @Test
  //wersja po ewentualnym refaktorze
  public void printAllAvailableLanguages2() {
    //1. przejście pod adres https://pl.wikipedia.org/wiki/Wiki
    navigateToWikipedia();

    //2. kliknięcie przycisku z listą dostępnych języków
    clickLanguageButton();
    By languageLink = By.cssSelector("a[class='autonym']");
    List<WebElement> availableLanguages = webDriver.findElements(languageLink);

    //3. wypisanie wszystkich dostępnych języków z listy
    printLanguages(availableLanguages);
  }

  private void navigateToWikipedia() {
    webDriver.get("https://pl.wikipedia.org/wiki/Wiki");
  }

  private void clickLanguageButton() {
    webDriver.findElement(By.id("p-lang-btn-checkbox")).click();
  }

  private void printLanguages(List<WebElement> languages) {
    for (WebElement language : languages) {
      String languageName = language.getText();
      String languageURL = language.getDomAttribute("href");

      if (languageName.equals("English")) {
        System.out.println(languageName + " (" + languageURL + ")");
      } else {
        System.out.println(languageName);
      }
    }
  }
}
