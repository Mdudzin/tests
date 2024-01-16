package com.gitlab.rmarzec.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class W3schoolsPage {

  @FindBy(id = "accept-choices")
  private WebElement acceptCookiesButton;
  @FindBy(xpath = "//a[@href='tryit.asp?filename=tryhtml_select']")
  private WebElement tryItYourselfButton;

  @FindBy(xpath = "//span[normalize-space()='The select element']")
  private WebElement h1Value;
  @FindBy(css = "select#cars")
  private WebElement carsSelect;

  public W3schoolsPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
  }

  public void acceptCookies() {
    acceptCookiesButton.click();
  }

  public void tryItYourself() {
    tryItYourselfButton.click();
  }

  public void printH1Field() {
    System.out.println(h1Value.getText());
  }

  public Select selectCar(String car) {
    Select cars = new Select(carsSelect);
    cars.selectByVisibleText(car);
    return cars;
  }
}
