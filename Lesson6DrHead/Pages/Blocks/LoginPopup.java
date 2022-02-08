package Lesson6DrHead.Pages.Blocks;


import Lesson6DrHead.Pages.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPopup implements WrapsElement {

    WebDriver webDriver;

    WebElement wrapElement;

    @Override
    public WebElement getWrappedElement() {
        return wrapElement;
    }

    public LoginPopup(WebDriver webDriver) {
        this.wrapElement = webDriver.findElement(By.xpath("//div[contains(@class, 'modal-wr is-open')]"));
        this.webDriver = webDriver;
    }

    By userNameInput = By.xpath("//form[contains(@class,'js-form-1')]//input[@name='USER_LOGIN']");
    By passwordInput = By.xpath("//form[contains(@class,'js-form-1')]//input[@name='USER_PASSWORD']");
    By loginButton = By.xpath("//button[@name='Login']");
    By errorDiv = By.xpath("//div[@class='modal-wr is-open']//div[@class='simplebar-content']//div[@class='error-message']");

    @Step("Авторизоваться с данными {login} и {password}")
    public MainPage login(String login, String password) {
        webDriver.findElement(userNameInput).sendKeys(login);
        webDriver.findElement(passwordInput).sendKeys(password);
        webDriver.findElement(loginButton).click();
        return new MainPage(webDriver);
    }


    // В этом методе произошла загвостка: само сообщение об ошибке появляется не сразу и нужно ставить ожидание.
    // Но оно срабатывает только если привязать к тексту ошибки.
    // Элемент, в котором расположен текст загружается сразу, поэтому ожидание по нему не срабатывает (то, что закомментила ниже).
    // Как то упоминать даже чать текста внутри метода кажется ненадежным, так как текст может со временем измениться.
    // Как в такой ситуации можно было бы поступить еще?

    @Step("Проверить наличие сообщения об ошибке {errorMessage}")
    public LoginPopup checkError(String errorMessage) {
        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Неверный')]")));
        //new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-wr is-open']//div[@class='simplebar-content']//div[@class='error-message']")));
        assertThat(webDriver.findElement(errorDiv).getText())
                .isEqualTo(errorMessage);
        return this;
    }
}
