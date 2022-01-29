package Lesson6DrHead.Pages;

import Lesson6DrHead.Pages.Blocks.MainHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage geolocation() {
        webDriver.findElement(By.xpath("//div[contains(@class, 'modal-location-question')]//button[contains(@class, 'location-question-confirm-btn')]")).click();
        return new MainPage(webDriver);
    }

    public MainPage windowSize() {
        webDriver.manage().window().setSize(new Dimension(1500, 1000));
        return this;
    }


}
