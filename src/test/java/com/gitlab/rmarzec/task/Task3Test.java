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
    GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
    W3schoolsPage w3schoolsPage = new W3schoolsPage(webDriver);
    navigateTo("https://www.google.com/");
    googleHomePage.acceptCookies();
    googleHomePage.fillSearchInput("HTML select tag - W3Schools");
    googleHomePage.clickFeelingLuckyButton();
    checkIfCurrentUrlEquals("https://www.w3schools.com/tags/tag_select.asp");
    w3schoolsPage.acceptCookies();
    w3schoolsPage.tryItYourself();
    switchToNewTab();
    w3schoolsPage.printH1Field();
    switchToFrame("iframeResult");
    Select cars = w3schoolsPage.selectCar("Opel");
    WebElement selectedOption = cars.getFirstSelectedOption();
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
