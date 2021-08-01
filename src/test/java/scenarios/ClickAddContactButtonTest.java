package scenarios;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class ClickAddContactButtonTest extends DriverSetup {

    @BeforeClass
    public static void setUp() throws Exception {
        prepareAndroidNative();
    }

    @Test
    public void clickButtonTest() {
        String appPackageName = "com.example.android.contactmanager:id/";
        By addButton = By.id(appPackageName + "addContactButton");
        driver.findElement(addButton).click();

        System.out.println("The Add Contact button is clicked");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}