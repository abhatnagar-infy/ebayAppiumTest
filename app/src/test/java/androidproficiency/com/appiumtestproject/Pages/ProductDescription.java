package androidproficiency.com.appiumtestproject.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProductDescription extends BasePage {

    private PageObjects productDescription;
    private String expectedProductName;

    private String expectedProductPrice;

    public String getExpectedProductName() {
        return expectedProductName;
    }

    public String getExpectedProductPrice() {
        return expectedProductPrice;
    }

    public ProductDescription(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
        productDescription = new PageObjects();
        PageFactory.initElements(this.driver, productDescription);
    }

    /**
     * To store the name and price of product and buy
     */
    public void buyProduct() {
        wait.until(ExpectedConditions.visibilityOf(productDescription.productCard));

        expectedProductName = wait.until(ExpectedConditions.visibilityOf(productDescription.name)).getText();
        expectedProductPrice = wait.until(ExpectedConditions.visibilityOf(productDescription.price)).getText();

        wait.until(ExpectedConditions.visibilityOf(productDescription.buyBtn)).click();
    }

    class PageObjects {
        @FindBy(id = "item_card_fragment_layout")
        WebElement productCard;

        @FindBy(id = "textview_item_name")
        WebElement name;

        @FindBy(id = "textview_item_price")
        WebElement price;

        @FindBy(id = "button_bin")
        WebElement buyBtn;
    }
}