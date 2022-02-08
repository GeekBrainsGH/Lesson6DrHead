package Lesson6DrHead.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Положить товар {productName} в корзину")

    public ProductsPage putProductInCart(String productName) {
        webDriver.findElement(By.xpath("//div[contains(@class, 'catalog-list__item') and contains(., '" + productName + "')]"))
                .findElement(By.xpath(".//button[contains(@class, 'buy-button')]")).click();
        return new ProductsPage(webDriver);
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='go_to_cart']")));
        webDriver.findElement(By.xpath("//div[@id='go_to_cart']//button[contains(@class, 'button button_primary')]")).click();
        return new CartPage(webDriver);
    }

    @Step("Перейти на страницу товара {product}")
    public CardProduct toProductPage(String product) {
        webDriver.findElement(By.xpath("//a[text() = '"+product+"']")).click();
        return new CardProduct(webDriver);
    }

    @Step("Сортировать продукты по {sortingkind}")
    public ProductsPage productSort(String sortingkind) {
        webDriver.findElement(By.xpath("//div[@class='drop-down-headline']")).click();
        webDriver.findElement(By.xpath("//span[contains(@onclick, '"+sortingkind+"')]")).click();
        return new ProductsPage(webDriver);
    }

    @Step("Проверить наличие продукта {firstProduct} после сортировки")
    public ProductsPage checkFirstProduct(String firstProduct) {
        List<WebElement> products = webDriver.findElements(By.xpath("//div[@id='catalog-list']"));
        assertThat(products.get(0).findElement(By.xpath("//a[contains(@class, 'product-title')]")).getText())
                .as("Название продукта к наивысшей стоимостью должно быть: " + firstProduct)
                .isEqualTo(firstProduct);
        return this;
    }

    @Step("Перейти в раздел быстрого просмотра")
    public ProductsPage quickView() {
        new Actions(webDriver)
                .moveToElement(webDriver.findElements(By.xpath("//div[contains(@class, 'check-show')]")).get(0))
                .click(webDriver.findElement(By.xpath("//button[contains(@class, 'product-quick')]")))
                .build()
                .perform();
        return new ProductsPage(webDriver);
    }

    @Step("Проверить наличие кнопки {buttonName}")
    public ProductsPage checkQuickView(String buttonName) {
        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'quick-view-preview__button')]")));
        assertThat(webDriver.findElement(By.xpath("//button[contains(@class, 'quick-view-preview__button')]")).getText().toLowerCase())
                .isEqualTo(buttonName);
        return this;
    }


}
