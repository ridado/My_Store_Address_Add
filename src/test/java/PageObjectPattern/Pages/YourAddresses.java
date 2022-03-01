package PageObjectPattern.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddresses {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement notificationBar;

    @FindBy(xpath= "//*[@class=\"address\"]/div[2]/a[2]/span")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"content\"]//div[1]/h4")
    private WebElement addressHeader;

    @FindBy(xpath = "//*[@class=\"address\"]/div[1]/address")
    private WebElement inputtedData;

    public YourAddresses(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String confirmationAddressSuccessfullyAddedDeleted(){
        return notificationBar.getText();
    }
    public void deleteAddress(){
        deleteButton.click();
    }
    public String getInputtedData(){
       return inputtedData.getText();
    }
    public String aliasIsCorrect(){
        return addressHeader.getText();
    }

}
