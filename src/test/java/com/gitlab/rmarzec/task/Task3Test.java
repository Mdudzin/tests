package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.utils.BaseTests;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Task3Test extends BaseTests {

  @Test
  public void navigateFromGoogleToW3Schools() {
    //1. Przejście pod adres https://www.google.com/
    webDriver.get("https://www.google.com/");

    //2. Akceptacja ciasteczek
    webDriver.findElement(By.id("L2AGLb")).click();

    //3. Wpisanie w polu wyszukiwania "HTML select tag - W3Schools"
    webDriver.findElement(By.id("APjFqb")).sendKeys("HTML select tag - W3Schools");

    //4. Kliknięcie „Szczęśliwy traf”
    By feelingLuckyButton = By.cssSelector("div[class='lJ9FBc'] input[name='btnI']");
    webDriver.findElement(feelingLuckyButton).click();

    //5. Zweryfikowanie czy trafiliśmy na stronę https://www.w3schools.com/tags/tag_select.asp
    //Jeśli nie, w konsoli należy wypisać informację z aktualnym adresem oraz przejść na podany
    //powyżej adres.
    if (!(webDriver.getCurrentUrl().equals("https://www.w3schools.com/tags/tag_select.asp"))) {
      System.out.println(webDriver.getCurrentUrl());
      webDriver.get("https://www.w3schools.com/tags/tag_select.asp");
    }

    //6. Akceptacja ciasteczek
    webDriver.findElement(By.id("accept-choices")).click();

    //7. Uruchomienie pierwszego przykładu przyciskiem "Try it Yourself"
    webDriver.findElement(By.xpath("//a[@href='tryit.asp?filename=tryhtml_select']")).click();

    //Przełączenie się na nowo otwartą kartę
    Set<String> tabs = webDriver.getWindowHandles();
    for (String tab : tabs) {
      if (tabs.size() > 1) {
        webDriver.switchTo().window(tab);
      }
    }

    //8. Pobranie WebElementu, który zawiera treść nagłówka (The select element)
    WebElement h1 = webDriver.findElement(By.xpath("//span[normalize-space()='The select element']"));

    //9. Wypisanie nagłówka w konsoli
    System.out.println(h1.getText());

    //Przełączenie się do ramki
    webDriver.switchTo().frame("iframeResult");

    //Namierzenie listy rozwijanej
    WebElement carsSelect = webDriver.findElement(By.cssSelector("select#cars"));

    //Utworzenie obiektu typu Select
    Select cars = new Select(carsSelect);

    //10. Wybranie z rozwijanej listy „Opel”
    cars.selectByVisibleText("Opel");

    //11. Pobranie wybranego elementu do WebElementu
    WebElement selectedOption = cars.getFirstSelectedOption();

    //11. Wypisanie w konsoli tekstu oraz wartości „value” (Opel, opel)
    System.out.println(selectedOption.getText() + ", " + selectedOption.getDomAttribute("value"));
  }
}
