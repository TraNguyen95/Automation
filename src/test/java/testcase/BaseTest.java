package testcase;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.WebDriverFactoryStaticThreadLocal;
import helpler.ReportHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    WebDriver driver;
    ExtentTest test;
    int count = 0;

    public int doMethod() {
        count++;
        return count;
    }

    public ExtentTest htmlLog(String mess) {
        return test.log(Status.INFO,doMethod() + ". " + mess);
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }
    @BeforeClass
    public void setUp()
    {
        WebDriverFactoryStaticThreadLocal.setDriver();
        System.out.println("BeforeClass");
        System.out.println("Browser setup by Thread "+Thread.currentThread().getId()+" and Driver reference is : "+WebDriverFactoryStaticThreadLocal.getDriver());
        driver = WebDriverFactoryStaticThreadLocal.getDriver();
        driver.get("https://www.w3schools.com/");
    }

    @AfterClass
    public void tearDown()
    {
        System.out.println("Browser closed by Thread "+Thread.currentThread().getId() + " and Closing driver reference is :"+WebDriverFactoryStaticThreadLocal.getDriver());
        WebDriverFactoryStaticThreadLocal.closeBrowser();

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");

    }
    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("End test");


    }


}








