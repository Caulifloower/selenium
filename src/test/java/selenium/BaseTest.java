package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;
    private static final String mainUrl = "http://google.pl";

    @BeforeEach
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to(mainUrl);
        closeCookiePopup();
    }

    private void closeCookiePopup() {
        driver.findElement(By.cssSelector("#L2AGLb")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
