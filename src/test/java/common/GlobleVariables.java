package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class GlobleVariables {
    public static WebDriver driver;

    public static String environment;

    public static ThreadLocal <ExtentTest> logger = new ThreadLocal<>();
    public static ThreadLocal <ExtentReports> ex = new ThreadLocal<>();

    public static ExtentReports ExT = ex.get();
}
