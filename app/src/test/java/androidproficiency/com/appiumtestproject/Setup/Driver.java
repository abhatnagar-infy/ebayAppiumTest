package androidproficiency.com.appiumtestproject.Setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Driver extends DriverSetup {

    public AppiumDriver<MobileElement> driver;

    protected Driver() {
        this.driver = super.getDriver();
    }
}