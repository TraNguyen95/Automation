package testcase;
import Page.*;
import com.aventstack.extentreports.Status;
import common.GlobleVariables;
import helpler.ReadFileJson;
import model.User;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_04 extends BaseTest{

    private DashboardPage dashboardPage;
    public SignInPage signInPage;
    public HomePage homePage;

@Test
public void learnJavaScriptTest() throws IOException, InterruptedException {
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
    htmlLog("Redirect to JavaScript Tutorial Page");
    homePage.learnJavaScriptClick();
    homePage.verifyLearnJavaScriptPage();

    htmlLog("Redirect to JavaScript Page");
    LearnJavaScriptPage learnJavaScriptPage = new LearnJavaScriptPage(driver);
    learnJavaScriptPage.studyJavaNowClick();
    JsIntroductonPage jsIntroductonPage = new JsIntroductonPage(driver);
    jsIntroductonPage.setTryItYourSelfClick();
}


}