package team6.pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import team6.common.BaseControl;
import team6.common.SoftAssertion;
import team6.helper.ReportHelper;

public class LearnJavaScriptPage {
    static WebDriver driver;
    private BaseControl studyJavaNowBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[3]/a");
    private String url = "https://my-learning.w3schools.com/";

    public  LearnJavaScriptPage(WebDriver driver) {
        this.driver=driver;
    }

    public static void verifyLearnJsIntroPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/js/js_intro.asp","Verify displayed LearnCSS Quiz page");
    }

    public void studyJavaNowClick() {
        studyJavaNowBtn.click();
        verifyLearnJsIntroPage();
        System.out.println(url);
    }
}
