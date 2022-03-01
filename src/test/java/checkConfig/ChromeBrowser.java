//Klasa sprawdzająca poprawność działania sterownika przeglądarki Chrome,
//        z przykładowym wyszukaniem wyników dla słowa "Selenium".


package checkConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Selenium");
        element.submit();
        driver.quit();
        System.out.println("Test zakończony pomyślnie");

    }
}
