package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.pageobjects.GoogleHomePage;
import com.gitlab.rmarzec.pageobjects.W3schoolsPage;
import com.gitlab.rmarzec.utils.BaseTests;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Task3Test extends BaseTests {

  @Test
  public void navigateFromGoogleToW3Schools() {
    //Inicjalizacja Page Objectów
    GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
    W3schoolsPage w3schoolsPage = new W3schoolsPage(webDriver);

    //1. Przejście pod adres https://www.google.com/
    navigateTo("https://www.google.com/");

    //2. Akceptacja ciasteczek
    googleHomePage.acceptCookies();

    //3. Wpisanie w polu wyszukiwania "HTML select tag - W3Schools"
    googleHomePage.fillSearchInput("HTML select tag - W3Schools");

    //4. Kliknięcie „Szczęśliwy traf”
    googleHomePage.clickFeelingLuckyButton();

    //5. Zweryfikowanie czy trafiliśmy na stronę https://www.w3schools.com/tags/tag_select.asp
    //Jeśli nie, w konsoli należy wypisać informację z aktualnym adresem oraz przejść na podany
    //powyżej adres.
    checkIfCurrentUrlEquals("https://www.w3schools.com/tags/tag_select.asp");

    //6. Akceptacja ciasteczek
    w3schoolsPage.acceptCookies();

    //7. Uruchomienie pierwszego przykładu przyciskiem "Try it Yourself"
    w3schoolsPage.tryItYourself();

    //Przełączenie się na nowo otwartą kartę
    switchToNewTab();

    //8. Pobranie WebElementu, który zawiera treść nagłówka (The select element)
    //9. Wypisanie nagłówka w konsoli
    w3schoolsPage.printH1Field();

    //Przełączenie się do ramki
    switchToFrame("iframeResult");

    //10. Wybranie z rozwijanej listy „Opel”
    Select cars = w3schoolsPage.selectCar("Opel");

    //11. Pobranie wybranego elementu do WebElementu
    WebElement selectedOption = cars.getFirstSelectedOption();

    //11. Wypisanie w konsoli tekstu oraz wartości „value” (Opel, opel)
    System.out.println(selectedOption.getText() + ", " + selectedOption.getDomAttribute("value"));
  }

  private void checkIfCurrentUrlEquals(String url) {
    if (!(webDriver.getCurrentUrl().equals(url))) {
      System.out.println(webDriver.getCurrentUrl());
      navigateTo(url);
    }
  }

  private void switchToNewTab() {
    Set<String> tabs = webDriver.getWindowHandles();
    for (String tab : tabs) {
      if (tabs.size() > 1) {
        webDriver.switchTo().window(tab);
      }
    }
  }
}
