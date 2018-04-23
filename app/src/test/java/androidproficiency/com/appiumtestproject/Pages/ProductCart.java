package androidproficiency.com.appiumtestproject.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProductCart extends BasePage {

    private PageObjects productCart;
    private String actualProductName;

    private String actualProductPrice;

    public String getActualProductName() {
        return actualProductName;
    }

    public String getActualProductPrice() {
        return actualProductPrice;
    }

    public ProductCart(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
        productCart = new PageObjects();
        PageFactory.initElements(driver, productCart);
    }

    public void reviewProduct() {
        actualProductName = wait.until(ExpectedConditions.visibilityOf(productCart.title)).getText();
        actualProductPrice = wait.until(ExpectedConditions.visibilityOf(productCart.price)).getText();
        wait.until(ExpectedConditions.visibilityOf(productCart.proceedBtn)).click();
    }

    class PageObjects {
        @FindBy(id = "item_title")
        WebElement title;

        @FindBy(id = "textview_item_price")
        WebElement price;

        @FindBy(id = "take_action")
        WebElement proceedBtn;
    }
}