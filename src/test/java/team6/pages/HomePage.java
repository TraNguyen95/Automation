package team6.pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import team6.common.BaseControl;
import team6.common.SoftAssertion;
import team6.helper.ReportHelper;

public class HomePage  {
    private static WebDriver driver;
    private BaseControl learnCSSBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[2]/div/div[1]/a[1]");
    private BaseControl javaScriptBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[3]/div/div[1]/a[1]");
    private BaseControl pythonBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[4]/div/div[1]/a[1]");
    private String url = "https://my-learning.w3schools.com/";

    //    public WebDriver driver;
    public  HomePage(WebDriver driver) {

        this.driver=driver;
    }

    public static void verifyHomepage () {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/","Verify Homepage");
    }

    public static void verifyLearnCssPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/css/default.asp","Verify displayed LearnCSS page");
    }

    public static void verifyLearnJavaScriptPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/js/default.asp","Verify displayed LearnJavaScript page");
    }

    public static void verifyLearnPythonPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/python/default.asp" +
                "" +
                "","Verify displayed LearnJavaScript page");
    }

    public void learnCssClick() {
        learnCSSBtn.click();
        verifyLearnCssPage();
        System.out.println("url learncssclick " + url);
    }

    public void learnJavaScriptClick() {
        javaScriptBtn.click();
        verifyLearnJavaScriptPage();
        System.out.println("url Learnjavascript " + url);
    }

    public void learnPythonClick() {
        pythonBtn.click();
        verifyLearnJavaScriptPage();
        System.out.println("url Learnjavascript " + url);
    }

}
