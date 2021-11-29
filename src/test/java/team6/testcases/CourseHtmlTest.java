package team6.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import team6.common.User;
import team6.helper.ReadFileJson;
import team6.pages.DashboardPage;
import team6.pages.SignInPage;

import java.io.IOException;


public class CourseHtmlTest extends BaseTest {
    private WebDriver driver;
    private DashboardPage dashboardPage;
    public SignInPage signInPage;
    private ReadFileJson readFileJson;

    @BeforeClass
    public void setupBrowser() {
        driver = getDriver();
    }




    @Test
    public void openTutorial() throws  IOException {
        readFileJson = new ReadFileJson();
        User user = readFileJson.readFileUser();
        signInPage = new SignInPage(driver);
        signInPage.signIn(user);
        dashboardPage = new DashboardPage(driver);
        dashboardPage.openTutorial();
        dashboardPage.htmlCourseClick();
        dashboardPage.studyBtnClick();
    }



}
