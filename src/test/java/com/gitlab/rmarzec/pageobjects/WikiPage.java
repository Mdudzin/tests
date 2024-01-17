package com.gitlab.rmarzec.pageobjects;

import com.gitlab.rmarzec.utils.WaitUtil;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {

  private WebDriver webDriver;

  @FindBy(id = "p-lang-btn-checkbox")
  private WebElement languageButton;
  @FindBy(css = "a[class='autonym']")
  private List<WebElement> languageLinks;

  public WikiPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    this.webDriver = webDriver;
  }

  public void clickLanguageButton() {
    languageButton.click();
  }

  public void printAvailableLanguages() {
    WaitUtil.waitForElementsToBeMoreThan(webDriver, By.cssSelector("a[class='autonym']"), 6);
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
}
