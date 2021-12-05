package testcase;
import java.io.IOException;

import Page.DashboardPage;
import Page.HomePage;
import Page.SignInPage;
import common.GlobleVariables;
import helpler.ReadFileJson;
import model.User;
import org.testng.annotations.Test;


public class TC_02 extends BaseTest {
    private DashboardPage dashboardPage;
    public SignInPage signInPage;
    public HomePage homePage;

    @Test
    public void JSParseTest() throws  IOException {
        test = GlobleVariables.logger.get();

        htmlLog("Start Test Case 2");

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
        htmlLog("Redirect to Referce Page");
        homePage.referenceBtnClick();

        htmlLog("Redirect JS-JSON Page");
        homePage.jsJsonBtnClick();

        htmlLog("Redirect JsonParse Page ");
        homePage.jsJsonParseBtnClick();
        homePage.verifyJsonParsePage();

    }

}