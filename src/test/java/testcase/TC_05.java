package testcase;

import Page.DashboardPage;
import Page.EditPage;
import Page.SignInPage;

import common.GlobleVariables;
import helpler.ReadFileJson;
import model.User;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_05 extends BaseTest {
    private DashboardPage dashboardPage;
    public SignInPage signInPage;
    private EditPage editPage;

    @Test
    public void ChangeFullNameTest() throws IOException, InterruptedException {
        test = GlobleVariables.logger.get();


        htmlLog("Start tc4");

        htmlLog("Read File Json");
        User user = ReadFileJson.readFileUser();
        signInPage = new SignInPage(driver);

        htmlLog("Login");
        signInPage.signIn(user);
        signInPage.verifyDashboardPage();

        htmlLog("Click setting button");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.settingClick();

        htmlLog("Input Name and update");
        editPage = new EditPage(driver);
        editPage.inputName();
        editPage.updateBtnClick();
        editPage.verifySuccessPop();


        htmlLog("Verify Name Display");
        editPage.myLearnningClick();
        dashboardPage.verifyFullName();

        htmlLog("End Testcase 4");

    }
}
