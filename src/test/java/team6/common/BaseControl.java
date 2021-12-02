package team6.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BaseControl {
    private String locator;
    WebDriverWait wait;
    WebDriver driver = GlobalVariable.driver;

    public BaseControl(String locator) {
        this.locator = locator;
        wait = new WebDriverWait(driver, 2);
    }

    public WebElement getElement() {

        By e = getLocatorFromString(locator);
        System.out.println(e);
        return driver.findElement(e);
    }

    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(getElement()));
        getElement().click();
//        System.out.println("abc");
    }

    public void getText() {
        getElement().getText();
    }

    public void enter(String abc) {
        getElement().sendKeys(abc);
    }

    private By getLocatorFromString(String locator) {
        String body = locator.replaceAll("[\\w\\s]*=(.*)","$1").trim();
        String type = locator.replaceAll("([\\w\\s]*)=.*","$1").trim();

        switch (type.toLowerCase()){
            case "css" :
                return By.cssSelector(body);
            case "id" :
                return By.id(body);
            case "xpath" :
                return By.xpath(body);
            case "class" :
                return By.className(body);
            default:
                return By.xpath(locator);
        }
    }
}
