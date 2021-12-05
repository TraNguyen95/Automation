package Page;

import common.BaseControl;
import common.SoftAssertion;
import org.openqa.selenium.WebDriver;

public class JsIntroductonPage {

    static WebDriver driver;
    private BaseControl tryItYourSelfBtn = new BaseControl("xpath =//*[@id=\"main\"]/div[4]/a");
    private String url = "https://my-learning.w3schools.com/";

    public JsIntroductonPage(WebDriver driver) {
        this.driver=driver;
    }

    public static void verifyTryItEditorPage() {
        String actualUrl = driver.getCurrentUrl();
        SoftAssertion.assertEqual(actualUrl,"https://www.w3schools.com/js/tryit.asp?filename=tryjs_intro_inner_html","Verify displayed Try It Quiz page");
    }

    public void setTryItYourSelfClick() {
        tryItYourSelfBtn.click();
        verifyTryItEditorPage();
        System.out.println(url);
    }



}
