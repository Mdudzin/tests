package com.gitlab.rmarzec.utils;

import java.util.Set;
import org.openqa.selenium.WebDriver;

public class BaseUtils {
  protected WebDriver webDriver;

  protected void navigateTo(String url) {
    webDriver.get(url);
  }

  protected void switchToFrame(String frameName) {
    webDriver.switchTo().frame(frameName);
  }

  protected void switchToNewTab() {
    Set<String> tabs = webDriver.getWindowHandles();
    for (String tab : tabs) {
      if (tabs.size() > 1) {
        webDriver.switchTo().window(tab);
      }
    }
  }
}
