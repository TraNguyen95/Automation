package Page;

import common.SoftAssertion;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private By accountInput = By.id("modalusername");
    private By passwordInput = By.id("current-password");
    private By signinBtn = By.className("_1VfsI");
    private By loginBtn = By.id("w3loginbtn");
    private By homeBtn = By.cssSelector("#w3s-top-nav-bar > div > div._1dCLy._1P2Ts > div > a");


    WebDriverWait wait;
    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 2);
    }

    public <user> void signIn(User user)
    {
        driver.findElement(loginBtn).click();

        driver.findElement(accountInput).sendKeys(user.account);
        driver.findElement(passwordInput).sendKeys(user.password);
        driver.findElement(signinBtn).click();

    }
    public void verifyDashboardPage() {
        String url = driver.getCurrentUrl();
        SoftAssertion.assertEqual(url,"https://profile.w3schools.com/","Verify Login success");
    }


}
