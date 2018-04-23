package androidproficiency.com.appiumtestproject.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

import androidproficiency.com.appiumtestproject.Utils.CommonUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage extends BasePage{

    private PageObjects loginPage;

    public LoginPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
        loginPage = new PageObjects();
        PageFactory.initElements(driver, loginPage);
    }

    public void signin() {
        Properties loginProps = CommonUtilities.getConfigValue(getClass(), "creds.properties");

        wait.until(ExpectedConditions.visibilityOf(loginPage.userNameFld));
        wait.until(ExpectedConditions.visibilityOf(loginPage.userNameFld)).sendKeys(loginProps.getProperty("username"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField)).sendKeys(loginProps.getProperty( "password"));
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginBtn)).click();
    }

    class PageObjects {
        @CacheLookup
        @FindBy(id = "button_sign_in")
        WebElement loginBtn;

        @CacheLookup
        @FindBy(id = "edit_text_username")
        WebElement userNameFld;

        @CacheLookup
        @FindBy(id = "edit_text_password")
        WebElement passwordField;
    }
}