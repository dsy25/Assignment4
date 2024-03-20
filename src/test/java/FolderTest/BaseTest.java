package FolderTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();

    //Before (Open Browser, Additional open website/URL)
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        //Getter and Setter untuk buka browser dan URL
        driver.set(new FirefoxDriver(options));
        driver.get().manage().window().maximize(); //maximize windows
        driver.get().get("https://demoblaze.com");
        explicitWait.set(new WebDriverWait((driver.get()), Duration.ofSeconds(120)));
    }

    //After (Close browser or close connection)
    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();
    }
}
