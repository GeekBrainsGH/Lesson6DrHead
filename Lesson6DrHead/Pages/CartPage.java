package Lesson6DrHead.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Проверить наличие товаров в корзине")
    public CartPage checkProductsInCart(String... productNames) {
        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id = 'content']//table[@class = 'cart-table']")));

        List<String> actualProducts = webDriver.findElements(By.xpath("//div[@id = 'content']//table[@class = 'cart-table']"))
                .stream().map(el -> el.findElement(By.xpath(".//tr[contains(@class, 'js-basket-elem')]//a[@class = 'link']")).getText())
                .collect(Collectors.toList());

        assertThat(actualProducts)
                .as("Название продукта в корзине должно соответствовать ожидаемому")
                .containsExactlyInAnyOrder(productNames);
        return new CartPage(webDriver);
    }
}
