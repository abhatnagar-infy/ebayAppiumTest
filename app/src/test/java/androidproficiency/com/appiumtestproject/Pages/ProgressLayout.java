package androidproficiency.com.appiumtestproject.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import androidproficiency.com.appiumtestproject.Utils.CommonUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProgressLayout extends BasePage {

    private final PageObjects progressLayout;

    public ProgressLayout(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
        progressLayout = new PageObjects();
        PageFactory.initElements(this.driver, progressLayout);
    }

    public boolean isProgressLayoutHidden() {
        List<WebElement> list = new ArrayList<>();
        list.add(progressLayout.progressLayout);

        if (CommonUtilities.existsElement(driver, "com.ebay.mobile:id/translucent_progress_layout"))
            wait.until(ExpectedConditions.invisibilityOfAllElements(list));

        return true;
    }

    class PageObjects {
        @CacheLookup
        @FindBy(id = "translucent_progress_layout")
        WebElement progressLayout;
    }
}
