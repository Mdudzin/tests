package com.gitlab.rmarzec.pageobjects;

import com.gitlab.rmarzec.model.YTTile;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubeHomePage {

  @FindBy(css = "button[aria-label^='Accept']")
  private WebElement acceptCookiesButton;
  @FindBy(xpath = ".//*[@id='video-title']")
  private List<WebElement> titles;
  @FindBy(xpath = ".//*[@id='text']/a")
  private List<WebElement> channelNames;
  @FindBy(xpath = ".//*[@id='time-status']/span")
  private List<WebElement> videoLengths;
  @FindBy(xpath = ".//div[@id='meta']")
  private List<WebElement> metaTexts;

  public YouTubeHomePage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
  }

  public void acceptCookies() {
    acceptCookiesButton.click();
  }

  public List<YTTile> createYtTileList() {
    List<YTTile> ytTileList = new ArrayList<>();

    for (int i = 0; i < 11; i++) {
      YTTile yTTile = new YTTile();
      yTTile.setTitle(titles.get(i + 1).getText());
      yTTile.setChannel(channelNames.get(i).getText());
      String metaText = metaTexts.get(i).getDomProperty("outerText").trim();

      if (metaText.contains("LIVE")) {
        yTTile.setLength("live");
      } else {
        yTTile.setLength(videoLengths.get(i).getDomProperty("innerText").trim());
      }
      ytTileList.add(yTTile);
    }
    return ytTileList;
  }
}
