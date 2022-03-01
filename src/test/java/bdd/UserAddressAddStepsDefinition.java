package bdd;

import PageObjectPattern.Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.WebDriverFactory;

public class UserAddressAddStepsDefinition {
    private WebDriver driver;

    @Given("user is on main My store main page")
    public void userIsOnMainMyStoreMainPage() {
        driver = WebDriverFactory.createChromedriverWithImplicitlyWait(10);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

    }
    @When("user clicks on sign in button, inputs {string} and {string}")
    public void userClicksOnSignInButtonInputsEmailAndPassword(String email, String password) {
//        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();
        LoginPage loginPage = new LoginPage(driver);
        // opcja z p.o.p:
        StartPage startPage = new StartPage(driver);
        startPage.signInClick();

        loginPage.userLogIn(email, password);
        Assertions.assertEquals("Clark Kent", loginPage.getNameOfLoggedUser());
    }
    @When("user clicks on my first address button")
    public void userClicksOnMyFirstAddressButton() {
//        driver.findElement(By.xpath("//*[@id=\"address-link\"]")).click();
// opcja z p.o.p:
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.createNewAddress();
    }
    @And("inputs data to form: {string}, {string}, {string}, {string}, {string}, {string}")
    public void inputsDataToForm(String alias, String address ,
                                 String postcode, String city, String country, String phone) {

        NewAddressPage newAddressPage =  new NewAddressPage(driver);

        newAddressPage.addNewAddress(alias, address, postcode, city, country, phone);

    }
    @And("clicks save button")
    public void clicksSaveButton() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
//        opcja z p.o.p
//        NewAddressPage newAddressPage = new NewAddressPage(driver);
//        newAddressPage.saveButtonClick();

    }
    @Then("Address is successfully added and {string}, {string}, {string}, {string}, {string}, {string}, {string} are correct")
    public void addressIsSuccessfullyAddedAndAreCorrect(String name, String alias, String address, String city, String postcode, String country, String phone) {

        YourAddresses yourAddresses = new YourAddresses(driver);

        Assertions.assertEquals("Address successfully added!",
                yourAddresses.confirmationAddressSuccessfullyAddedDeleted());
        Assertions.assertEquals(alias, yourAddresses.aliasIsCorrect());
        String correctData = name +"\n" + address + "\n" + city + "\n" + postcode + "\n" + country + "\n" + phone;
        Assertions.assertEquals(correctData, yourAddresses.getInputtedData());
    }
    @Then("user clicks on delete button and checks if address is successfully deleted")
    public void userClicksOnDeleteButtonAndChecksIfAddressIsSuccessfullyDeleted() {
        YourAddresses yourAddresses = new YourAddresses(driver);

        yourAddresses.deleteAddress();
        Assertions.assertEquals("Address successfully deleted!",
                yourAddresses.confirmationAddressSuccessfullyAddedDeleted());
    }
    @And("user shut down browser")
    public void userShutDownBrowser() {
        driver.quit();
    }
}
