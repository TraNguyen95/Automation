package team6.pages;

import org.openqa.selenium.WebDriver;
import team6.common.BaseControl;
import team6.common.SoftAssertion;

public class LearnCssPage {
    static WebDriver driver;
    private BaseControl cssQuizBtn = new BaseControl("xpath = //*[@id=\"main\"]/p[13]/a");
    private String url = "https://my-learning.w3schools.com/";

    public  LearnCssPage(WebDriver driver) {
        this.driver=driver;
    }

    public static void verifyLearnCssQuizPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/css/css_quiz.asp","Verify displayed LearnCSS Quiz page");
    }

    public void cssQuizBtnClick() {
        cssQuizBtn.click();
        verifyLearnCssQuizPage();
        System.out.println(url);
    }
}
