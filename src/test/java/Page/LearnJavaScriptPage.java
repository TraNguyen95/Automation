package Page;

import common.BaseControl;
import common.SoftAssertion;
import org.openqa.selenium.WebDriver;

public class LearnJavaScriptPage {
    static WebDriver driver;
    private BaseControl studyJavaNowBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[3]/a");
    private String url = "https://my-learning.w3schools.com/";

    public LearnJavaScriptPage(WebDriver driver) {
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
