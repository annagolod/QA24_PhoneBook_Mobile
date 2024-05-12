package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

public class LoginTestsSecond extends AppiumConfig {

    @Test
    public void loginSuccess(){
        new AuthenticationScreen(driver)
                .fillEmail("tretam0810@gmail.com")
                .fillPassword("Phone54321#")
                .submitLogin()
                .isAccountOpened()
                .logout();

    }

    @Test
    public void loginSuccessModel(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("tretam0810@gmail.com")
                        .password("Phone54321#")
                        .build())
                .submitLogin()
                .isAccountOpened()
                .logout();

    }

    @Test
    public void loginWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("tretam0810gmail.com")
                        .password("Phone54321#")
                        .build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }


}
