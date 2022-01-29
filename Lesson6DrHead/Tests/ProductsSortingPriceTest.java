package Lesson6DrHead.Tests;

import Lesson5DrHead.BaseTest;
import Lesson6DrHead.Pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("Sort products by price")
public class ProductsSortingPriceTest extends BaseTest {

    String section = "Полноразмерные";
    String sortingKind = "price&order=desc"; // убывание цены
    String firstProduct = "Sennheiser Orpheus HE-1";

    @ParameterizedTest
    @ValueSource(strings = {"Sennheiser Orpheus HE-1"})
    @DisplayName("Sort products by descending price: positive")
    void ProductsSortingPriceDownTest(String productName) throws InterruptedException {
        webDriver.get(URL);

        new MainPage(webDriver)
                .geolocation()
                .windowSize()
                .getMainHeader()
                .goToProductsPage(section)
                .productSort(sortingKind)
                .checkFirstProduct(firstProduct);

    }
}
