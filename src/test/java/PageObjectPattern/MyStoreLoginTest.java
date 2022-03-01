package PageObjectPattern;

import PageObjectPattern.Pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import helpers.WebDriverFactory;

public class MyStoreLoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createChromedriverWithImplicitlyWait(10);

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        System.out.println("Test zakończony");}

    @Test
    public void clickToSignIn() {

        // arrange
        String name = "Clark Kent";
        String alias = "superman";
        String email = "clark.kent@mail.com";
        String password = "Super123";
        String address = "Komiksowa 5";
        String postcode = "00-456";
        String city = "Krypton";
        String country = "United Kingdom";
        String phone = "690987654";
        StartPage startPage = new StartPage(driver);
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        YourAddresses yourAddresses = new YourAddresses(driver);


        // act
        startPage.signInClick();
        loginPage.userLogIn(email, password);

        Assertions.assertEquals("Clark Kent", loginPage.getNameOfLoggedUser());

        yourAccountPage.createNewAddress();
        newAddressPage.addNewAddress(alias,address, postcode, city, country, phone);
        newAddressPage.saveButtonClick();
        Assertions.assertEquals("Address successfully added!", yourAddresses.confirmationAddressSuccessfullyAddedDeleted());
        Assertions.assertEquals(alias, yourAddresses.aliasIsCorrect());
        String correctData = name +"\n" + address + "\n" + city + "\n" + postcode + "\n" + country + "\n" + phone;
        Assertions.assertEquals(correctData, yourAddresses.getInputtedData());
        yourAddresses.deleteAddress();
        Assertions.assertEquals("Address successfully deleted!", yourAddresses.confirmationAddressSuccessfullyAddedDeleted());
    }
}