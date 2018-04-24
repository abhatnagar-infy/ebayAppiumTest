package androidproficiency.com.appiumtestproject.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import androidproficiency.com.appiumtestproject.Utils.CommonUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProductList extends BasePage {

    private PageObjects productList;

    public ProductList(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
        productList = new PageObjects();
        PageFactory.initElements(this.driver, productList);
    }

    /**
     * Select random item from list of products
     */
    public void chooseRandomItem() {
        wait.until(ExpectedConditions.visibilityOf(productList.recycler));

        int fakeSwipeCount = 0;

        while (fakeSwipeCount != 2) {
            CommonUtilities.performSwipe(driver, productList.recyclerList);
            fakeSwipeCount++;
        }

        productList.products.get(0).click();
    }

    class PageObjects {
        @FindBy(id = "recycler")
        WebElement recycler;

        @FindBy(id = "cell_collection_item")
        List<WebElement> recyclerList;

        @FindBy(id = "textview_item_price")
        List<WebElement> products;
    }
}