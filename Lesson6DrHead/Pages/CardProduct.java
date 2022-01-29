package Lesson6DrHead.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class CardProduct extends BasePage{
    public CardProduct(WebDriver webDriver) {
        super(webDriver);
    }

    public CardProduct chooseColor() {

    new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'quick-view-color']")));
    webDriver.findElement(By.xpath("//span[@style = 'background-color: #800080;']")).click();

        return new CardProduct(webDriver);
    }


    // В этом методе необходимо было поставить ожидание, чтобы загрузился товар нового цвета.
    // Но все эелементы у него похожи с прошлым.
    // К названию ожидание не стала привязывать, чтобы не было лишней зависимости и тест не упал с ошибкой до исполнения.
    // Привязала к вендор коду, но это тоже ненадежная зависимость.
    // Попытки найти xpath к активному цвету с нужным кодом не привели к успеху. Там придется еще выставлять зависимость по порядковому номеру.
    public CardProduct checkName(String vendorCode, String newNameProduct) {
        new WebDriverWait(webDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '"+vendorCode+"')]")));
        assertThat(webDriver.findElement(By.xpath("//h1[@class = 'quick-view-title']")).getText()).isEqualTo(newNameProduct);
        return this;
    }
}
