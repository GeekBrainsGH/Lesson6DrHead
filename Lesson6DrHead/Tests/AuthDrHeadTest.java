package Lesson6DrHead.Tests;

import Lesson5DrHead.BaseTest;
import Lesson6DrHead.Pages.Blocks.LoginPopup;
import Lesson6DrHead.Pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Authorization DrHead")
public class AuthDrHeadTest extends BaseTest {
    String login = "test_202334@mail.ru";
    String password = "123456789n";
    String invalidPassword = "invalidPassword";

    @Test
    @DisplayName("Authorization DrHead: positive")
    void successfulAuthTest() {
        webDriver.get(URL);

        new MainPage(webDriver)
                .geolocation()
                .windowSize()
                .getMainHeader()
                .clickLoginButton()
                .login(login, password)
                .getMainHeader()
                .logout()
                .getMainHeader()
                .checkLoginButtonIsVisible();
    }

    @Test
    @DisplayName("Authorization DrHead: negative - Invalid password")
    void negativeAuthInvalidPasswordTest() {

        webDriver.get(URL);

        new MainPage(webDriver)
                .geolocation()
                .windowSize()
                .getMainHeader()
                .clickLoginButton()
                .login(login, invalidPassword);
        new LoginPopup(webDriver)
                .checkError("Неверный логин или пароль.");
    }
    }

