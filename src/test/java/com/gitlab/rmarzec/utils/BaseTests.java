package com.gitlab.rmarzec.utils;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests extends BaseUtils {

  @BeforeMethod
  public void setup() {
    DriverFactory driverFactory = new DriverFactory();
    webDriver = driverFactory.initDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
  }

  @AfterMethod
  public void tearDown() {
    webDriver.quit();
  }
}
