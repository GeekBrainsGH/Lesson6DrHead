//package Lesson6DrHead.Pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class LoginPage extends BasePage {
//
//    @FindBy(xpath = "//form[contains(@class,'js-form-1')]//input[@name='USER_LOGIN']")
//    private WebElement userNameInput;
//
//    @FindBy(xpath = "//form[contains(@class,'js-form-1')]//input[@name='USER_PASSWORD']")
//    private WebElement passwordInput;
//
//    @FindBy(xpath = "//button[@name='Login']")
//    private WebElement loginButton;
//
//    @FindBy(xpath = "//div[@class='modal-wr is-open']//div[@class='simplebar-content']//div[@class='error-message']")
//    private WebElement errorDiv;
//
//    public LoginPage(WebDriver webDriver) {
//        super(webDriver);
//    }
//
//    public MainPage login(String login, String password) {
//        userNameInput.sendKeys(login);
//        passwordInput.sendKeys(password);
//        loginButton.click();
//        return new MainPage(webDriver);
//    }
//
//
//    // В этом методе произошла загвостка: само сообщение об ошибке появляется не сразу и нужно ставить ожидание.
//    // Но оно срабатывает только если привязать к тексту ошибки.
//    // Элемент, в котором расположен текст загружается сразу, поэтому ожидание по нему не срабатывает (то, что закомментила ниже).
//    // Как то упоминать даже чать текста внутри метода кажется ненадежным, так как текст может со временем измениться.
//    // Как в такой ситуации можно было бы поступить еще?
//    public LoginPage checkError(String errorMessage) {
//        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Неверный')]")));
//        //new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-wr is-open']//div[@class='simplebar-content']//div[@class='error-message']")));
//        assertThat(errorDiv.getText())
//                .isEqualTo(errorMessage);
//        return this;
//    }
//}
