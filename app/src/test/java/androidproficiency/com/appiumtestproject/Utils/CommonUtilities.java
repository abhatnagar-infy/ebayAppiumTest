package androidproficiency.com.appiumtestproject.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class CommonUtilities {

    private static final String TAG = CommonUtilities.class.getSimpleName();

    /**
     * To check if an element exists or not
     * @param driver Appium driver
     * @param id id of element
     * @return if an element exists
     */
    public static boolean existsElement(AppiumDriver driver, String id) {
        try {
            driver.findElement(By.id(id));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /***
     * To swipe the screen based on position of web elements
     * @param driver Appium driver
     * @param list list of elements to perform swipe on
     */

    public static void performSwipe(AppiumDriver driver, List<WebElement> list) {
        WebElement bottomElement = list.get(list.size() - 1);
        WebElement topElement = list.get(0);
        TouchAction touchAction = new TouchAction(driver).press(bottomElement).moveTo(topElement).release();
        touchAction.perform();
    }

    /***
     * To read value of a config file
     * @param context class context
     * @param fileName file to be read
     * @return all properties from the file
     */
    public static Properties getConfigValue(Class context, String fileName) {
        ClassLoader classLoader = context.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        FileInputStream fileInput = null;
        Properties properties = new Properties();

        try {
            fileInput = new FileInputStream(file);
            properties.load(fileInput);
            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}