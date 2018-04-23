package androidproficiency.com.appiumtestproject.Setup;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverSetup {

    private DesiredCapabilities caps = new DesiredCapabilities();
    private AppiumDriver<MobileElement> androidDriver = null;

    DriverSetup() {
        initDriver();
    }

    public AppiumDriver getDriver() {
        if (null == androidDriver) {
            initDriver();
        }
        return androidDriver;
    }

    private void initDriver() {
        System.out.println("Inside initDriver method");

        caps.setCapability("deviceName", "lg1");
        caps.setCapability("udid", "LGD8554708604f"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.4.2");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.ebay.mobile");
        caps.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
        caps.setCapability("noReset", "false");

        try {
            androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } catch (NullPointerException | MalformedURLException ex) {
            throw new RuntimeException("appium driver could not be initialised for device ");
        }
        System.out.println("Driver in initdriver is : " + androidDriver);
    }
}