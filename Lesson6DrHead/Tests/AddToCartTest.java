package Lesson6DrHead.Tests;

import Lesson5DrHead.BaseTest;
import Lesson6DrHead.Pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Add to cart")
public class AddToCartTest extends BaseTest {

    @DisplayName("Add to cart: positive")
    @ParameterizedTest
    @ValueSource(strings = {"Sony MDR-7506", "Sony HT-ZF9"})
    void addToCartTest(String productNames){

        webDriver.get(URL);
        new MainPage(webDriver)
                .geolocation()
                .windowSize()
                .getMainHeader()
                .useSearchField("Sony")
                .putProductInCart(productNames)
                .goToCart()
                .checkProductsInCart(productNames);
    }
}
