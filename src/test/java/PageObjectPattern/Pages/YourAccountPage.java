package PageObjectPattern.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {

    private WebDriver driver;

    @FindBy(id = "address-link")
    private WebElement addFirstAddressButton;

    public YourAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewAddress(){
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=my-account");
        addFirstAddressButton.click();
    }

}
