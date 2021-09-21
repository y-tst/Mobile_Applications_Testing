package service;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter extends DriverSetup{

    protected static final int TIMEOUT_IN_SECONDS = 10;

    public static boolean waitForElementVisibility(WebElement element) {
        try {
            new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
        }
        catch (StaleElementReferenceException exception) {
            exception.getStackTrace();
        }

        return element.isEnabled();
    }
}
