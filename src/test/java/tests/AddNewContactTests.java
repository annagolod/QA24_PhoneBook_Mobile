package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactTests extends AppiumConfig {

    @BeforeClass
    public void preCondition() {
        new AuthenticationScreen(driver).fillLoginRegistrationForm(Auth.builder().email("tretam0810@gmail.com")
                        .password("Phone54321#").build())
                .submitLogin();
    }

    @Test
    public void createNewContactSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Maria")
                .lastName("Desan" + i)
                .email("mardes" + i + "@gmail.com")
                .phone("12647579" + i)
                .address("NY")
                .description("friend")
                .build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(), contact.getLastName());
    }

    @Test
    public void createNewContactSuccessReq() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Maria")
                .lastName("Desan" + i)
                .email("mardes" + i + "@gmail.com")
                .phone("12647579" + i)
                .address("NY")
                .build();

        new ContactListScreen(driver).openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(), contact.getLastName());
    }

    @Test
    public void createNewContactWithEmptyName() {
        Contact contact = Contact.builder()
                .lastName("Desan")
                .email("mardes@gmail.com")
                .phone("126475792852")
                .address("NY")
                .description("Empty name")
                .build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorContainsText("{name=must not be blank}");
    }


    @AfterClass
    public void postCondition() {
        new ContactListScreen(driver).logout();
    }
}
