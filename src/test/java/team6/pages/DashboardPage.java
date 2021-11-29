package team6.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import team6.common.BaseControl;
import team6.common.SoftAssertion;
import team6.helper.ReportHelper;
import team6.testcases.BaseTest;


public class DashboardPage extends PageBase {
    private BaseControl tutorialBtn = new BaseControl("xpath = //*[@id=\"headingcircle_1\"]");
    private String url = "https://my-learning.w3schools.com/";
    private BaseControl htmlCourse = new BaseControl("css = #htmltext");
    private BaseControl stydyBtn = new BaseControl("xpath = //*[@id=\"tutorialgotobtn\"]");
    private BaseControl settingBtn = new BaseControl("xpath = //*[@id=\"navigation\"]/a[5]");
    private BaseControl firstNameInput = new BaseControl("xpath = //*[@id=\"modal_first_name\"]");
    private BaseControl lastNameInput = new BaseControl("xpath = //*[@id=\"modal_last_name\"]");
    private BaseControl updateBtn = new BaseControl("xpath = //*[@id=\"root\"]/div[2]/div[1]/div/div/button");
    private BaseControl homeBtn = new BaseControl("xpath = //*[@id=\"w3s-top-nav-bar\"]/div/div[3]/div/a");
    private BaseControl learnCSSBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[2]/div/div[1]/a[1]");
    private BaseControl cssQuizBtn = new BaseControl("xpath = //*[@id=\"main\"]/p[13]/a");
    private BaseControl startQuizBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[3]/p[2]/a");
    private BaseControl crlBtn = new BaseControl("xpath = //*[@id=\"label1\"]");

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest test = ReportHelper.getTest();

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 2);
    }

    public void openTutorial() {
        tutorialBtn.click();
    }
    public void htmlCourseClick() {
//        wait.until(ExpectedConditions.elementToBeClickable(HtmlCourse));
        htmlCourse.click();
    }
    public void studyBtnClick() {
        stydyBtn.click();
    }

    public void settingClick() {
        settingBtn.click();
    }
    public void inputName() throws InterruptedException {
        firstNameInput.enter("Team");
        lastNameInput.enter("six");

        Thread.sleep(2000);
        updateBtn.click();
    }
    public void backHome() {
        homeBtn.click();
    }
    public void verifyHomepage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/","Verify Hompage");
    }
    public void learnCssClick() {
        learnCSSBtn.click();

        String url = driver.getCurrentUrl();
        SoftAssertion.assertEqual(url,"https://www.w3schools.com/","Verify displayed LearnCss page");

        System.out.println("url learncssclick " + url);
    }
    public void cssQuizBtnClick() {
        cssQuizBtn.click();
        String url = driver.getCurrentUrl();
        SoftAssertion.assertEqual(url,"https://www.w3schools.com/css/css_quiz.asp","Verify CSS quiz Page");
        System.out.println(url);
    }
    public void startQuizBtnClick() {
        startQuizBtn.click();
        SoftAssertion.assertEqual(url,"https://www.w3schools.com/css/css_quiz.asp","Verify CSS quiz Page");
    }
    public void crlQuestion() {
        crlBtn.click();
    }

}
