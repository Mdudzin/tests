package com.gitlab.rmarzec.pageobjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiPage {
  @FindBy(id = "p-lang-btn-checkbox")
  private WebElement languageButton;
  @FindBy(css = "a[class='autonym']")
  private List<WebElement> languageLinks;

  public WikiPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
  }

  public void clickLanguageButton() {
    languageButton.click();
  }

  public void printAvailableLanguages() {
    for (WebElement language : languageLinks) {
      String languageName = language.getText();
      String languageURL = language.getDomAttribute("href");

      if (languageName.equals("English")) {
        System.out.println(languageName + " (" + languageURL + ")");
      } else {
        System.out.println(languageName);
      }
    }
  }

  public void waitForLinks(WebDriver webDriver) {
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("a[class='autonym']"),6));
  }
}
