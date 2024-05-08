package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationScreen extends BaseScreen {

    public AuthenticationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    AndroidElement emailEditText;

    @FindBy(id= "com.sheygam.contactapp:id/inputPassword")
    AndroidElement passwordEditText;

    @FindBy(id= "com.sheygam.contactapp:id/loginBtn")
    AndroidElement loginBtn;

    public AuthenticationScreen fillEmail(String email) {
        should(emailEditText, 10);
        type(emailEditText, email);
        return this;
    }

    public AuthenticationScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }

    public ContactListScreen submitLogin() {
        loginBtn.click();
        return new ContactListScreen(driver);
    }
}
