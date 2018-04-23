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

    public static boolean existsElement(AppiumDriver driver, String id) {
        try {
            driver.findElement(By.id(id));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public static void performSwipe(AppiumDriver driver, List<WebElement> list) {
        WebElement bottomElement = list.get(list.size() - 1);
        WebElement topElement = list.get(0);
        TouchAction touchAction = new TouchAction(driver).press(bottomElement).moveTo(topElement).release();
        touchAction.perform();
    }

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