package team6.pages;

import org.openqa.selenium.WebDriver;
import team6.common.BaseControl;

public class QuizCssTestPage {
    static WebDriver driver;
    private BaseControl crlBtn = new BaseControl("xpath = //*[@id=\"label1\"]");

    public  QuizCssTestPage(WebDriver driver) {
        this.driver=driver;
    }

    public void crlQuestion() {
        crlBtn.click();
    }
}
