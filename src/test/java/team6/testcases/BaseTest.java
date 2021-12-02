package team6.testcases;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import team6.common.GlobalVariable;
import team6.helper.ReportHelper;

public class BaseTest {

    protected static WebDriver driver;


    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test1;
    protected static String evName;



    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void startExtent(ITestContext context) {
        System.out.println("start setup extent");
        htmlReporter = new ExtentHtmlReporter("./output/report3.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test1  = extent.createTest("Test Extent Report", "Team 6");
        ReportHelper.setTest(test1);

        evName  = context.getCurrentXmlTest().getParameter("environment");
        GlobalVariable.environment = evName;
          }
    @AfterSuite
    public void endExtent() {
        System.out.println("End extent");
        driver.close();
        driver.quit();

        extent.flush();
    }

    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL);
        }
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        GlobalVariable.driver =  driver;
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    @Parameters({ "browserType", "appURL" })

    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            setDriver(browserType, appURL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }



    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //to write or update test information to reporter

    }

}


