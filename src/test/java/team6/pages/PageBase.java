package team6.pages;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class PageBase {

    protected static WebDriver driver;

    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentReports extent;
    protected static ExtentTest test1;





    @AfterTest
    public void tearDown() throws InterruptedException {
        System.out.println("End");
        extent.flush();
    }

}


