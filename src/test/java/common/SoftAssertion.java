package common;

import com.aventstack.extentreports.Status;
import helpler.ReportHelper;
import helpler.ScreenShotHelper;
import org.openqa.selenium.WebDriver;

public class SoftAssertion {
    private static String nameImg;
    protected static WebDriver driver;

    public static void assertEqual(String actual,String expected,String message)
    {
        if(actual.contains(expected)){
            ReportHelper.getTest().log(Status.PASS,message + "<br>Actual: " + actual);
        }else {
            try {
                driver = WebDriverFactoryStaticThreadLocal.getDriver();
                nameImg = ScreenShotHelper.getScreenshot(driver,"testScreen");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String path = nameImg;
            ReportHelper.logFail(actual,expected,message,path);
        }
    }
}
