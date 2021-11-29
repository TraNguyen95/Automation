package team6.testcases;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import team6.common.User;
import team6.helper.ReadFileJson;
import team6.pages.SignInPage;

import java.io.IOException;


public class SignInTest extends BaseTest {

    private WebDriver driver;
    public SignInPage signInPage;
    private ReadFileJson readFileJson;


    @BeforeClass
    public void setupBrowser() {
        System.out.println("tra");
        driver = getDriver();
    }

    @Test
    public void signPage() throws InterruptedException, IOException {
        System.out.println(evName);
        readFileJson = new ReadFileJson();
        User user = readFileJson.readFileUser();
        signInPage = new SignInPage(driver);
        signInPage.signIn(user);

        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }



}
