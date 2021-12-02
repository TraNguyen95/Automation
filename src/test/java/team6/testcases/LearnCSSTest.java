package team6.testcases;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import team6.common.User;
import team6.helper.ReadFileJson;
import team6.pages.*;

import java.io.IOException;


public class LearnCSSTest extends BaseTest {
    private WebDriver driver;
    private DashboardPage dashboardPage;
    public SignInPage signInPage;
    private ReadFileJson readFileJson;

    @BeforeClass
    public void setupBrowser() {
        driver = getDriver();
    }

    @Test
    public void learnCSSTest() throws IOException, InterruptedException {

        test1.log(Status.INFO,"1.Start Test");
        readFileJson = new ReadFileJson();

        test1.log(Status.INFO,"2.Read File User Json");
        User user = readFileJson.readFileUser();
        signInPage = new SignInPage(driver);

        test1.log(Status.INFO,"3.Login ");
        signInPage.signIn(user);

        Thread.sleep(2000);
        signInPage.verifyDashboardPage();

        dashboardPage = new DashboardPage(driver);
        System.out.println("start log");
        test1.log(Status.INFO,"4.Redirect to Home Page");
        dashboardPage.backHome();
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomepage();
        System.out.println("end log 1");

        HomePage homePage1 = new HomePage(driver);
        test1.log(Status.INFO,"5.Redirect to CSS Tutorial Page");
        homePage1.learnCssClick();
//        dashboardPage.learnCssClick();
        System.out.println("end log");

        LearnCssPage learnCssPage = new LearnCssPage(driver);
        test1.log(Status.INFO,"6.Redirect to CSS Quiz Page");
        learnCssPage.cssQuizBtnClick();
        LearnCssQuizPage learnCssQuizPage = new LearnCssQuizPage(driver);
        learnCssQuizPage.startQuizBtnClick();
        QuizCssTestPage quizCssTestPage = new QuizCssTestPage(driver);
        quizCssTestPage.crlQuestion();


    }
}
