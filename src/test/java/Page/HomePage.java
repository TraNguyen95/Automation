package Page;

import common.BaseControl;
import common.SoftAssertion;
import org.openqa.selenium.WebDriver;


public class HomePage extends PageBase{
    private BaseControl referenceBtn = new BaseControl("xpath = //*[@id=\"navbtn_references\"] ");
    private BaseControl jsJsonBtn = new BaseControl("xpath = //*[@id=\"leftmenuinnerinner\"]/div/a[9] ");
    private BaseControl learnCSSBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[2]/div/div[1]/a[1]");
    private BaseControl jsChildBtn = new BaseControl("xpath = //*[@id=\"nav_references\"]/div/div/div[3]/a[1]");
    private BaseControl getJsJsonParseBtn = new BaseControl("xpath = //*[@id=\"leftmenuinnerinner\"]/div/div[7]/a[1]");
    private BaseControl javaScriptBtn = new BaseControl("xpath = //*[@id=\"main\"]/div[3]/div/div[1]/a[1]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void learnCssClick() {
        learnCSSBtn.click();
    }
    public void jsJsonBtnClick() {
        jsJsonBtn.click();
    }
    public void jsJsonParseBtnClick() {
        getJsJsonParseBtn.click();
    }
    public void learnJavaScriptClick() {javaScriptBtn.click();}

    public void referenceBtnClick() {
        referenceBtn.click();
        jsChildBtn.click();
    }
    public void verifyJsonParsePage() {
        String url = driver.getCurrentUrl();
        SoftAssertion.assertEqual(url,"https://www.w3schools.com/jsref/jsref_parse_json.asp","Verify displayed LearnCss page");
    }

    public void verifyLeanCssPage() {
        String url = driver.getCurrentUrl();
        SoftAssertion.assertEqual(url,"https://www.w3schools.com/","Verify displayed LearnCss page");
    }

    public void verifyLearnJavaScriptPage() {
        String url = driver.getCurrentUrl();
        SoftAssertion.assertEqual(url,"https://www.w3schools.com/js/default.asp","Verify displayed LearnJavaScript page");
    }


}
