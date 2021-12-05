import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class TestGrid {
    public WebDriver driver;
    String URL = "https://google.com";
    String Node = "http://localhost:4444/wd/hub";
    boolean status = false;

    @BeforeClass
    public void testSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");

        /* The execution happens on the Selenium Grid with the address mentioned earlier */
        driver = new RemoteWebDriver(new URL(Node), caps);
    }

    @Test
    public void testGG() throws InterruptedException {
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        try {
            /* Let's mark done first two items in the list. */
            driver.findElement(By.className("gLFyf")).sendKeys("Team 6");
            driver.findElement(By.className("gNO89b")).click();


            System.out.println("Selenium Grid Standalone Testing Is Complete");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
