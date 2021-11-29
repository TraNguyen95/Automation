package team6.common;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import team6.helper.ReportHelper;
import team6.helper.ScreenShotHelper;
import team6.testcases.BaseTest;

public class SoftAssertion extends BaseTest {
    private static String nameImg;
    protected static WebDriver driver;

    public static void assertEqual(String actual,String expected,String message)
    {
        if(actual.equalsIgnoreCase(expected)){
            ReportHelper.getTest().log(Status.PASS,message);
        }else {
            try {
                driver = getDriver();
                nameImg = ScreenShotHelper.getScreenshot(driver,"testScreen");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String path = nameImg;
            ReportHelper.logFail(message,path);
        }
    }
}
