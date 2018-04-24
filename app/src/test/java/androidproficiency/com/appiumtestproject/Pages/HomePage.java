package androidproficiency.com.appiumtestproject.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static androidproficiency.com.appiumtestproject.Utils.CommonUtilities.getConfigValue;

public class HomePage extends BasePage {

    private PageObjects homePage;

    public HomePage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
        homePage = new PageObjects();
        PageFactory.initElements(driver, homePage);
    }

    /**
     * To navigate to login page
     */
    public void gotToLoginPage() {
        wait.until(ExpectedConditions.visibilityOf(homePage.signInBtn)).click();
    }

    /**
     * To search a product
     */
    public void searchProduct() {
        wait.until(ExpectedConditions.visibilityOf(homePage.searchBox)).click();
        wait.until(ExpectedConditions.visibilityOf(homePage.searchText)).click();
        Properties properties = getConfigValue(getClass(), "product");
        wait.until(ExpectedConditions.visibilityOf(homePage.searchText)).sendKeys(properties.getProperty("product1"));

        driver.hideKeyboard();

        wait.until(ExpectedConditions.visibilityOf(homePage.suggestionList));

        driver.findElementById("com.ebay.mobile:id/suggestionList")
                .findElementsByClassName("android.widget.RelativeLayout").get(0).click();
    }

    class PageObjects {
        @CacheLookup
        @FindBy(id = "button_sign_in")
        WebElement signInBtn;

        @CacheLookup
        @FindBy(id = "search_box")
        WebElement searchBox;

        @CacheLookup
        @FindBy(id = "search_src_text")
        WebElement searchText;

        @CacheLookup
        @FindBy(id = "suggestionList")
        WebElement suggestionList;
    }
}