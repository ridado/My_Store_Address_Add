package PageObjectPattern.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //inicjalizacja sterownika

    private final WebDriver driver;

    // wyszukanie elementów na stronie

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    @FindBy(className = "account")
    private WebElement userLabel;

    // konstruktor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // metoda do zalogowania się użytkownika

    public void userLogIn(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
    public String getNameOfLoggedUser(){
        return userLabel.getText();

    }
}
