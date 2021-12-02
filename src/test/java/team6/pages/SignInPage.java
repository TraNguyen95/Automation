package team6.pages;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import team6.common.SoftAssertion;
import team6.common.User;
import team6.helper.ReportHelper;
import team6.testcases.BaseTest;

public class SignInPage extends PageBase {

    WebDriverWait wait;
    WebDriver driver;
    private By accountInput = By.id("modalusername");
    private By passwordInput = By.id("current-password");
    private By signInBtn = By.className("_1VfsI");
    private By loginBtn = By.id("w3loginbtn");
    ExtentTest test = ReportHelper.getTest();


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 2);
    }


    public <user> void signIn(User user)
    {
        driver.findElement(loginBtn).click();
//        Status status = PageBase.verifyUrl("https://profile.w3schools.com/") ? Status.PASS : Status.FAIL;


//        wait.until(ExpectedConditions.elementToBeClickable(accountInput));
        driver.findElement(accountInput).sendKeys(user.account);
        driver.findElement(passwordInput).sendKeys(user.password);
        driver.findElement(signInBtn).click();

    }
    public void verifyDashboardPage() {
        String url = driver.getCurrentUrl();
        SoftAssertion.assertEqual(url,"my-learning.w3schools.com","Verify Login success");
    }
}

