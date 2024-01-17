package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.model.YTTile;
import com.gitlab.rmarzec.pageobjects.YouTubeHomePage;
import com.gitlab.rmarzec.utils.BaseTests;
import java.util.List;
import org.testng.annotations.Test;

public class Task4Test extends BaseTests {

  private final String youtubeUrl = "https://www.youtube.com/";

  @Test
  public void extractAndPrintYTTileData() {
    YouTubeHomePage youTubeHomePage = new YouTubeHomePage(webDriver);
    navigateTo(youtubeUrl);
    youTubeHomePage.acceptCookies();
    List<YTTile> ytTileList = youTubeHomePage.createYtTileList();
    printTitlesAndLength(ytTileList);
  }

  private void printTitlesAndLength(List<YTTile> ytTileList) {
    for (YTTile yTTile : ytTileList) {
      if (!(yTTile.getLength().equals("live"))) {
        System.out.println(yTTile.getTitle() + " : " + yTTile.getLength());
        System.out.println(
            "============================================================================================================");
      }
    }
  }
}
