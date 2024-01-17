package com.gitlab.rmarzec.pageobjects;

import com.gitlab.rmarzec.utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

  private WebDriver webDriver;

  @FindBy(id = "APjFqb")
  private WebElement searchInput;
  @FindBy(id = "L2AGLb")
  private WebElement acceptCookiesButton;
  @FindBy(css = "div[class='lJ9FBc'] input[name='btnI']")
  private WebElement feelingLuckyButton;

  public GoogleHomePage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    this.webDriver = webDriver;
  }

  public void acceptCookies() {
    acceptCookiesButton.click();
  }

  public void clickFeelingLuckyButton() {
    WaitUtil.waitForElementToBeClickable(webDriver, feelingLuckyButton);
    feelingLuckyButton.click();
  }

  public void fillSearchInput(String text) {
    searchInput.sendKeys(text);
  }
}
