package androidproficiency.com.appiumtestproject.Pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

class BasePage {

    final AppiumDriver<MobileElement> driver;
    final WebDriverWait wait;

    public BasePage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}