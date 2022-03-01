package PageObjectPattern.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {

    private WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasField;

    @FindBy(name = "address1")
    private WebElement addressField;

    @FindBy(name = "postcode")
    private WebElement postcodeField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select")
    private WebElement countryDropdown;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;


    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement addresSuccessfullyAdded;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress(String alias, String address, String postcode, String city, String country, String phone) {

        aliasField.sendKeys(alias);
        addressField.sendKeys(address);
        postcodeField.sendKeys(postcode);
        cityField.sendKeys(city);
        countryDropdown.sendKeys(country);
//        countryDropdown.click();
        phoneField.sendKeys(phone);
    }

    public void saveButtonClick(){
        saveButton.click();
    }
}
