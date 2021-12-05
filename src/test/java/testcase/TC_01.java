package testcase;
import Page.DashboardPage;
import Page.HomePage;
import Page.SignInPage;
import common.GlobleVariables;
import helpler.ReadFileJson;
import model.User;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_01 extends BaseTest{

    private DashboardPage dashboardPage;
    public SignInPage signInPage;
    public HomePage homePage;


    @Test
    public void LearnCssQuizTest() throws InterruptedException, IOException {
        test = GlobleVariables.logger.get();

        htmlLog("Start Test Case LearnCssQuizPageTest");

        htmlLog("Read File User Json");
        User user = ReadFileJson.readFileUser();
        signInPage = new SignInPage(driver);

        htmlLog("Login");
        signInPage.signIn(user);
        signInPage.verifyDashboardPage();

        dashboardPage = new DashboardPage(driver);

        htmlLog("Redirect to Home Page");
        dashboardPage.backHome();
        dashboardPage.verifyHomepage();

        homePage = new HomePage(driver);
        htmlLog("Redirect to CSS Tutorial Page");
        homePage.learnCssClick();
        homePage.verifyLeanCssPage();

        htmlLog("Redirect to CSS Quiz Page");
        dashboardPage.cssQuizBtnClick();
        dashboardPage.verifyCSSQuizPage();


        htmlLog("Verify CSS Course Page");
        dashboardPage.startQuizBtnClick();
        dashboardPage.verifyCourseCSSPage();

    }


}