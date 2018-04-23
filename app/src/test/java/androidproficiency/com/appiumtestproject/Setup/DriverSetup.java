package androidproficiency.com.appiumtestproject.Setup;

import org.eclipse.jetty.util.annotation.ManagedObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import androidproficiency.com.appiumtestproject.Utils.CommonUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverSetup {

    private DesiredCapabilities caps = new DesiredCapabilities();
    private AppiumDriver<MobileElement> androidDriver = null;

    DriverSetup() {
        initDriver();
    }

    /**
     * Instantiate and get the driver with device and app capabilities
     * @return
     */
    public AppiumDriver getDriver() {
        if (null == androidDriver) {
            initDriver();
        }
        return androidDriver;
    }

    private void initDriver() {
        Properties configProperties = CommonUtilities.getConfigValue(getClass(), "config.properties");

        caps.setCapability(MobileCapabilityType.DEVICE_NAME, configProperties.getProperty("deviceName"));
        caps.setCapability(MobileCapabilityType.UDID, configProperties.getProperty("udid")); //DeviceId from "adb devices" command
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configProperties.getProperty("platformName"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, configProperties.getProperty("platformVersion"));
        caps.setCapability("skipUnlock", "true");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ebay.mobile");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.ebay.mobile.activities.MainActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET, "false");

        try {
            androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } catch (NullPointerException | MalformedURLException ex) {
            throw new RuntimeException("appium driver could not be initialised for device ");
        }
        System.out.println("Driver in initdriver is : " + androidDriver);
    }
}