package Lesson6DrHead.Pages;

import Lesson6DrHead.Pages.Blocks.MainHeader;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class BasePage extends BaseView{

    @Getter
    private MainHeader mainHeader = new MainHeader(webDriver);

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }
}
