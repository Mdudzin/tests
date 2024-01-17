package com.gitlab.rmarzec.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

  public static void waitForElementsToBeMoreThan(WebDriver webDriver, By locator, Integer number) {
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
  }

  public static void waitForElementToBeClickable(WebDriver webDriver, WebElement webElement) {
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }
}
