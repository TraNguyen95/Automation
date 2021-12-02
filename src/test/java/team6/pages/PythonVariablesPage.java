package team6.pages;

import org.openqa.selenium.WebDriver;
import team6.common.BaseControl;
import team6.common.SoftAssertion;

public class PythonVariablesPage {
    static WebDriver driver;
    private BaseControl tryItYourSelfBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[4]/a");
    private String url = "https://my-learning.w3schools.com/";

    public  PythonVariablesPage(WebDriver driver) {
        this.driver=driver;
    }

    public static void verifyDemoVariablesPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/python/trypython.asp?filename=demo_variables2","Verify displayed Try It Quiz page");
    }

    public void setTryItYourSelfClick() {
        tryItYourSelfBtn.click();
        verifyDemoVariablesPage();
        System.out.println(url);
    }
}
