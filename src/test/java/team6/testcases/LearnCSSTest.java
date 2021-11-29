package team6.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import team6.common.User;
import team6.helper.ReadFileJson;
import team6.pages.DashboardPage;
import team6.pages.SignInPage;

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

        test1.log(Status.INFO,"4.Redirect to Home Page");
        dashboardPage.backHome();
        dashboardPage.verifyHomepage();

        test1.log(Status.INFO,"5.Redirect to CSS Tutorial Page");
        dashboardPage.learnCssClick();

        test1.log(Status.INFO,"6.Redirect to CSS Quiz Page");
        dashboardPage.cssQuizBtnClick();
        dashboardPage.startQuizBtnClick();
        dashboardPage.crlQuestion();


    }
}
