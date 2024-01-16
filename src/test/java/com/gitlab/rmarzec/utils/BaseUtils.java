package com.gitlab.rmarzec.utils;

import org.openqa.selenium.WebDriver;

public class BaseUtils {
  protected WebDriver webDriver;

  protected void navigateTo(String url) {
    webDriver.get(url);
  }

  protected void switchToFrame(String frameName) {
    webDriver.switchTo().frame(frameName);
  }
}
