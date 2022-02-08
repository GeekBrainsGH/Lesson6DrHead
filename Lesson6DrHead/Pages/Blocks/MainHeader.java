package Lesson6DrHead.Pages.Blocks;

import Lesson6DrHead.Pages.BaseView;
import Lesson6DrHead.Pages.MainPage;
import Lesson6DrHead.Pages.ProductsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class MainHeader extends BaseView {

    @FindBy(xpath = "//div[contains(@class, 'header-menu')]//a[contains(@class, 'header-menu__item_login')]")
    private WebElement loginButton;

    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Перейти на страницу {section}")
    public ProductsPage goToProductsPage(String section) {

        webDriver.findElement(By.xpath("//div[contains(@class, 'header-nav__item_hamburger')]//div[@class = 'dropdown-value']")).click();
        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-catalog-main']//div[@data-section-id='1781']")));
        webDriver.findElement(By.xpath("//div[@data-section-id='1781']//a[text() = '"+section+"']")).click();
        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='page-catalog__content']")));

        return new ProductsPage(webDriver);

    }

    @Step("Ввести в поисковую строку {product}")
    public ProductsPage useSearchField(String product) {
        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='top-search-line']")));
        webDriver.findElement(By.xpath("//input[@id='top-search-line']")).sendKeys(product);
        webDriver.findElement(By.xpath("//div[contains(@class, 'header-content')]//button[contains(@class, 'search-block__button')]")).click();
        return new ProductsPage(webDriver);
    }

    @Step("Нажать на кнопку Логин")
    public LoginPopup clickLoginButton() {
        loginButton.click();
        return new LoginPopup(webDriver);
    }

    @Step("Выйти из системы")
    public MainPage logout() {
        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='header-menu__item_login-img lozad-loaded']")));
        webDriver.findElement(By.xpath("//div[contains(@class, 'header-menu')]//a[contains(@class, 'header-menu__item_login')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'lk-nav')]//a[@href='/personal/?logout=yes']")).click();
        new WebDriverWait(webDriver,15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'header-menu')]//a[contains(@class, 'header-menu__item_login')]")));
        return new MainPage(webDriver);
    }
    @Step("Проверить отображение кнопки Логин")
    public MainPage checkLoginButtonIsVisible() {
        webDriver.findElement(By.xpath("//div[contains(@class, 'header-menu')]//a[contains(@class, 'header-menu__item_login')]")).click();
        assertThat(webDriver.findElement(By.name("Login")).getText().toLowerCase()).isEqualTo("войти");
        return new MainPage(webDriver);
    }

}
