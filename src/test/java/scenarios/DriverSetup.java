package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    protected static AndroidDriver driver;

    protected static void  prepareAndroidNative() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("plaformName","Android");

        File appDir = new File("D:\\Learning\\Automation_Mentoring\\M13_mobile_testing\\sample-code-master\\sample-code\\apps\\ContactManager");
        File app = new File(appDir, "ContactManager.apk");

        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
