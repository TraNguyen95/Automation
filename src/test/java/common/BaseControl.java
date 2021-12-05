package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseControl {
    private String locator;
    WebDriverWait wait;
    WebDriver driver = WebDriverFactoryStaticThreadLocal.getDriver();

    public BaseControl(String locator) {
        this.locator = locator;
        wait = new WebDriverWait(driver, 10);
    }


    public WebElement getElement() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorFromString(locator)));
        By e = getLocatorFromString(locator);

        return  driver.findElement(e);
    }
    public void click() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorFromString(locator)));
        By e = getLocatorFromString(locator);
        driver.findElement(e).click();
    }

    public String getText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorFromString(locator)));
        return getElement().getText();
    }

    public void enter(String abc) {
        getElement().clear();
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