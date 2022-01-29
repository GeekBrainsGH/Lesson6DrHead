package Lesson6DrHead.Tests;

import Lesson5DrHead.BaseTest;
import Lesson6DrHead.Pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Color switch")
public class ColorCheckTest extends BaseTest {

    String section = "Беспроводные";
    String nameProduct = "Anker Soundcore Liberty 3 Pro Eclipse Black";
    String newNameProduct = "Anker Soundcore Liberty 3 Pro Nebula Purple";
    String vendorCode = "121080";

    @Test
    @DisplayName("Color switch: positive")
    void colorSwitchPositiveTest() {
        webDriver.get(URL);

        new MainPage(webDriver)
                .geolocation()
                .windowSize()
                .getMainHeader()
                .goToProductsPage(section)
                .toProductPage(nameProduct)
                .chooseColor()
                .checkName(vendorCode, newNameProduct);

    }
}
