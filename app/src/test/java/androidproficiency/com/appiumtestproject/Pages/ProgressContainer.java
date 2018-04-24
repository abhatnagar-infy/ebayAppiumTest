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

public class ProgressContainer extends BasePage {

    private final PageObjects progressLayout;

    public ProgressContainer(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
        progressLayout = new PageObjects();
        PageFactory.initElements(this.driver, progressLayout);
    }

    /**
     * To wait until the progress container becomes invisible
     * @return when progress container becomes invisible
     */
    public boolean isProgressContainerHidden() {
        List<WebElement> list = new ArrayList<>();
        list.add(progressLayout.progressContainer);

        if (CommonUtilities.existsElement(driver, "com.ebay.mobile:id/progressContainer"))
            wait.until(ExpectedConditions.invisibilityOfAllElements(list));

        return true;
    }

    class PageObjects {
        @CacheLookup
        @FindBy(id = "progressContainer")
        WebElement progressContainer;
    }
}
