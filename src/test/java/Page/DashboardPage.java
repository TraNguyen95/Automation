package Page;

import com.aventstack.extentreports.ExtentTest;
import common.BaseControl;
import common.SoftAssertion;
import helpler.ReportHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private BaseControl settingBtn = new BaseControl("xpath = //*[@id=\"navigation\"]/a[5]");
    private By settingElement = By.xpath("//*[@id=\"navigation\"]/a[5]");
    private BaseControl homeBtn = new BaseControl("xpath = //*[@id=\"w3s-top-nav-bar\"]/div/div[3]/div/a");
    private BaseControl cssQuizBtn = new BaseControl("xpath = //*[@id=\"main\"]/p[13]/a");
    private BaseControl startQuizBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[3]/p[2]/a");
    private BaseControl crlBtn = new BaseControl("xpath = //*[@id=\"label1\"]");
    private BaseControl fullName = new BaseControl("xpath = //*[@id=\"profile-name\"]");

    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }



    public void settingClick() {
        wait.until(ExpectedConditions.elementToBeClickable(settingElement));
        settingBtn.click();
    }

    public void backHome() {
       homeBtn.click();
    }
    public void verifyHomepage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/","Verify Hompage");
    }

    public void cssQuizBtnClick() {
        cssQuizBtn.click();

    }
    public void verifyCSSQuizPage() {
        String url = driver.getCurrentUrl();
        SoftAssertion.assertEqual(url,"https://www.w3schools.com/css/css_quiz.asssp","Verify CSS quiz Page");
    }
    public void startQuizBtnClick()  {
        startQuizBtn.click();
    }
    public void verifyCourseCSSPage() {
        crlBtn.click();
        String url = driver.getCurrentUrl();
        SoftAssertion.assertEqual(url,"https://www.w3schools.com/quiztest/quiztest.asp?qtest=CSS","Verify CSS quiz Page");
    }


    public void verifyFullName() {
        String fn = fullName.getText();
        SoftAssertion.assertEqual(fn,"Team six","Verify Full Name display correct");
    }
}
