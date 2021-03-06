package Lesson6DrHead.Tests;

import Lesson5DrHead.BaseTest;
import Lesson6DrHead.Pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Quick view")
public class QuickViewTest extends BaseTest {

    String section = "Вставные";
    String buttonName = "подробнее о товаре";


    @Test
    @DisplayName("Quick view: positive")
    void quickViewTest() throws InterruptedException {
        webDriver.get(URL);

        new MainPage(webDriver)
                .geolocation()
                .windowSize()
                .getMainHeader()
                .goToProductsPage(section)
                .quickView()
                .checkQuickView(buttonName);
    }
}
