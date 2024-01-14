package com.gitlab.rmarzec.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
    public WebDriver initDriver(){
        WebDriver webDriver = new ChromeDriver();
        tlDriver.set(webDriver);
        return getDriver();
    }
}
