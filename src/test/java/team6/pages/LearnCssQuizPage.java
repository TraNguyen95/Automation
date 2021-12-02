package team6.pages;

import org.openqa.selenium.WebDriver;
import team6.common.BaseControl;
import team6.common.SoftAssertion;

public class LearnCssQuizPage {
    private static WebDriver driver;
    private String url = "https://my-learning.w3schools.com/";
    private BaseControl startQuizBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[3]/p[2]/a");


    public  LearnCssQuizPage(WebDriver driver) {
        this.driver=driver;
    }

        public static void verifyStartCssPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/css/css_quiz.asp","Verify displayed Start learn CSS quiz page");
    }

    public void startQuizBtnClick() {
        startQuizBtn.click();
        verifyStartCssPage();
    }
}
