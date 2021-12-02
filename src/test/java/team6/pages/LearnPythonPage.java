package team6.pages;

import org.openqa.selenium.WebDriver;
import team6.common.BaseControl;
import team6.common.SoftAssertion;

public class LearnPythonPage {
    static WebDriver driver;
    private BaseControl nextBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[2]/a[2]");
    private BaseControl pythonVariablesBtn = new BaseControl("xpath = //*[@id=\"leftmenuinnerinner\"]/a[6]");
    private String url = "https://my-learning.w3schools.com/";

    public  LearnPythonPage(WebDriver driver) {
        this.driver=driver;
    }

    public static void verifyPythonIntroPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/python/python_intro.asp","Verify displayed Python Intro page");
    }

    public static void verifyPythonVariablesPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/python/python_variables.asp","Verify displayed Python Variables page");
    }

    public void nextClick() {
        nextBtn.click();
        verifyPythonIntroPage();
        System.out.println(url);
    }

    public void pythonVariablesClick() {
        pythonVariablesBtn.click();
        verifyPythonVariablesPage();
        System.out.println(url);
    }
}
