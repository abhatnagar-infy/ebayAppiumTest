package androidproficiency.com.appiumtestproject.Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import androidproficiency.com.appiumtestproject.Pages.EnrollmentPage;
import androidproficiency.com.appiumtestproject.Pages.HomePage;
import androidproficiency.com.appiumtestproject.Pages.LoginPage;
import androidproficiency.com.appiumtestproject.Pages.ProductCart;
import androidproficiency.com.appiumtestproject.Pages.ProductDescription;
import androidproficiency.com.appiumtestproject.Pages.ProductList;
import androidproficiency.com.appiumtestproject.Pages.ProgressContainer;
import androidproficiency.com.appiumtestproject.Pages.ProgressLayout;
import androidproficiency.com.appiumtestproject.Setup.Driver;

/***
 * A basic test to Automation the scenario “Login to eBay mobile application and search for an
 item and add to cart and purchase it”
 */
public class SearchProductTest extends Driver {

    public WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;
    private EnrollmentPage enrollmentPage;
    private ProgressContainer progressContainer;
    private ProductList productList;
    private ProgressLayout progressLayout;
    private ProductDescription productDescription;
    private ProductCart productCart;

    @Before
    public void setup() throws MalformedURLException {
        wait = new WebDriverWait(driver, 50);

        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        enrollmentPage = new EnrollmentPage(driver, wait);
        progressContainer = new ProgressContainer(driver, wait);
        productList = new ProductList(driver, wait);
        progressLayout = new ProgressLayout(driver, wait);
        productDescription = new ProductDescription(driver, wait);
        productCart = new ProductCart(driver, wait);
    }

    @Test
    public void basicTest() throws InterruptedException {
        homePage.gotToLoginPage();

        loginPage.signin();
        enrollmentPage.enroll();

        homePage.searchProduct();

        if(progressContainer.isProgressContainerHidden()) {
            productList.chooseRandomItem();
        }

        if(progressLayout.isProgressLayoutHidden()) {
            productDescription.buyProduct();
        }

        productCart.reviewProduct();

        Assert.assertTrue("Product title is different ", productCart.getActualProductName().contains(productDescription.getExpectedProductName()));
        Assert.assertEquals("Product price is different ", productDescription.getExpectedProductPrice(), productCart.getActualProductPrice());

        Thread.sleep(20000);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}