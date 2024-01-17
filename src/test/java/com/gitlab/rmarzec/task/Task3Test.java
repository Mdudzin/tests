package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.pageobjects.GoogleHomePage;
import com.gitlab.rmarzec.pageobjects.W3schoolsPage;
import com.gitlab.rmarzec.utils.BaseTests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Task3Test extends BaseTests {

  private final String googleUrl = "https://www.google.com/";
  private final String w3schoolsUrl = "https://www.w3schools.com/tags/tag_select.asp";
  private final String inputText = "HTML select tag - W3Schools";
  private final String iframeName = "iframeResult";
  private final String carMake = "Opel";
  private final String domAttribute = "value";

  @Test
  public void navigateFromGoogleToW3Schools() {
    GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
    W3schoolsPage w3schoolsPage = new W3schoolsPage(webDriver);

    navigateTo(googleUrl);
    googleHomePage.acceptCookies();
    googleHomePage.fillSearchInput(inputText);
    googleHomePage.clickFeelingLuckyButton();
    checkIfCurrentUrlEquals(w3schoolsUrl);
    w3schoolsPage.acceptCookies();
    w3schoolsPage.tryItYourself();
    switchToNewTab();
    w3schoolsPage.printH1Field();
    switchToFrame(iframeName);
    Select cars = w3schoolsPage.selectCar(carMake);
    WebElement selectedOption = cars.getFirstSelectedOption();

    System.out.println(selectedOption.getText() + ", " + selectedOption.getDomAttribute(domAttribute));
  }

  private void checkIfCurrentUrlEquals(String url) {
    if (!(webDriver.getCurrentUrl().equals(url))) {
      System.out.println("Current URL: " + webDriver.getCurrentUrl());
      navigateTo(url);
    }
  }
}
