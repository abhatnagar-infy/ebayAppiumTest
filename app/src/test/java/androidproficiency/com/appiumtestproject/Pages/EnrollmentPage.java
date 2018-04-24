package androidproficiency.com.appiumtestproject.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import androidproficiency.com.appiumtestproject.Utils.CommonUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class EnrollmentPage extends BasePage {

    private PageObjects enrollmentPage;

    public EnrollmentPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
        enrollmentPage = new PageObjects();
        PageFactory.initElements(this.driver, enrollmentPage);
    }

    /**
     * Verify if enrollment page appears and perform action
     */
    public void enroll() {
        if (CommonUtilities.existsElement(driver, "com.ebay.mobile:id/before_enrollment")) {
            wait.until(ExpectedConditions.visibilityOf(enrollmentPage.denyBtn)).click();
        }
    }

    class PageObjects {
        @CacheLookup
        @FindBy(id = "before_enrollment")
        WebElement enrollmntPage;

        @CacheLookup
        @FindBy(id = "button_google_deny")
        WebElement denyBtn;
    }
}