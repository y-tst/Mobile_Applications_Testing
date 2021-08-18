package service;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    protected static AndroidDriver driver;
    private static final String TEST_DEVICE = "emulator-5554";
    private static final String TEST_PLATFORM = "Android";
    private static final String APPLICATION_PATH = "src\\main\\resources";
    private static final String APPLICATION_NAME = "ContactManager.apk";
    private static final String HOST_URL = "http://127.0.0.1:4723/wd/hub";

    protected static void prepareAndroidNative() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", TEST_DEVICE);
        capabilities.setCapability("platformName", TEST_PLATFORM);

        File appDir = new File(APPLICATION_PATH);
        File app = new File(appDir, APPLICATION_NAME);

        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL(HOST_URL), capabilities);
    }
}
