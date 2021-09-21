package scenarios;

import io.appium.java_client.MobileBy;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import service.DriverSetup;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.logging.Logger;

import static service.Waiter.waitForElementVisibility;

public class ClickAddContactButtonTest extends DriverSetup {

    public Logger logger = Logger.getGlobal();

    @BeforeClass
    public static void setUp() throws Exception {
        prepareAndroidNative();
    }

    @Test
    public void clickButtonTest() throws InterruptedException {
        String appPackageName = "com.example.android.contactmanager:id/";
        By addButton = By.id(appPackageName + "addContactButton");

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        driver.findElementByAndroidUIAutomator("text('Continue')").click();
//        driver.findElementByXPath("//android.widget.CheckedTextView[@text='Continue']").click();


        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        allowAppPermission();

        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoGrantPermissions", true);

//        driver.findElement(By.xpath(".//android.widget.Button[@text='Continue']")).click();
//        driver.findElement(By.xpath(".//android.widget.Button[@text='Ok']")).click();

        driver.findElement(By.id("android:id/button1")).click();

        waitForElementVisibility(driver.findElement(addButton));
        driver.findElement(addButton).click();

        waitForElementVisibility(driver.findElement(By.id("android:id/title")));
        String pageTitle = driver.findElement(By.id("android:id/title")).getText();

        logger.info(String.format("The Add Contact button is clicked, page title is: %s", pageTitle));

        Assert.assertEquals("Incorrect page Opened","Add Contact", pageTitle);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    public void allowAppPermission() {
        while (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).size() > 0) {
            driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();
        }
    }
}