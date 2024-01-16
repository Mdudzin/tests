package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.model.YTTile;
import com.gitlab.rmarzec.utils.BaseTests;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Task4Test extends BaseTests {

  @Test
  public void saveYTTileData() {
    //1. Przejście pod adres https://www.youtube.com/
    webDriver.get("https://www.youtube.com/");

    //2. Akceptacja ciasteczek
    webDriver.findElement(By.cssSelector("button[aria-label^='Accept']")).click();

    //3. Dla pierwszych 12 kafelków należy pobrać informację i zapisać w liście obiektów List<YTTile>:
    //a) Tytuł
    //b) Nazwa kanału
    //c) Długość (jeśli jest to transmisja na żywo – wpisać wartość „live”)
    List<WebElement> titles = webDriver.findElements(By.xpath(".//*[@id='video-title']"));
    List<WebElement> channelNames = webDriver.findElements(By.xpath(".//*[@id='text']/a"));
    List<WebElement> videoLengths = webDriver.findElements(By.xpath(".//*[@id='time-status']/span"));

    List<YTTile> ytTileList = new ArrayList<>();

    for (int i = 0; i < 11; i++) {
      YTTile yTTile = new YTTile();
      yTTile.setTitle(titles.get(i + 1).getText());
      yTTile.setChannel(channelNames.get(i).getText());
      yTTile.setLength(videoLengths.get(i).getDomProperty("innerText").trim());
      ytTileList.add(yTTile);
    }

    //4. Wypisać z utworzonej listy tytuł oraz czas trwania dla wszystkich filmów, które nie są
    //transmitowane na żywo.
    for (YTTile yTTile : ytTileList) {
      if (!(yTTile.getLength().equals("live"))) {
        System.out.println(yTTile.getTitle() + " " + yTTile.getLength());
      }
    }
  }
}
