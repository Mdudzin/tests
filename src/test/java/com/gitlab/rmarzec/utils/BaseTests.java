package com.gitlab.rmarzec.utils;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

  private DriverFactory driverFactory;
  protected WebDriver webDriver;

  @BeforeMethod
  public void setup() {
    this.driverFactory = new DriverFactory();
    this.webDriver = driverFactory.initDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
  }

  @AfterMethod
  public void tearDown() {
    webDriver.quit();
  }
}
