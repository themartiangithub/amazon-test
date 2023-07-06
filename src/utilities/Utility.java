package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /*
    This method will click on element
    */

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    /*
    This method will return text from element
    */
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    /*
    This method will send text to element
    */
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    public String getAttributeValue(By by, String name){
        return driver.findElement(by).getAttribute(name);
    }


    /*
    This method will select the option by visible text
    */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);

        //Select by visible text
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String value) {

        new Select(driver.findElement(by)).selectByValue(value);

    }

    public void selectByIndexFromDropDown(By by, int index) {

        new Select(driver.findElement(by)).selectByIndex(index);

    }

    public static String getAlphaNumericString(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    /**
     * This method will return list of WebElements
     */
    public List<WebElement> getListOfElements(By by) {
        return driver.findElements(by);
    }

//************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will send text from alert
     */
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    /**
     * This method will select the option by contains text
     */
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    /**
     * This method will select the option by contains text from List of Elements
     */
    public void selectByContainsTextFromListOfElements(By by, String text) {
        List<WebElement> webElementList = driver.findElements(by);
        for (WebElement element : webElementList) {
            if (element.getText().contains(text)) {
                element.click();
                break;
            }
        }
    }

//*************************** Window Handle Methods ***************************************//

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
//*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    /*
    This method will verify text from webpage
    */
    public void verifyTwoStrings(String text , By by) {
        String expected = text;
        String actual = driver.findElement(by).getText();
        Assert.assertEquals(expected, actual);
    }

}
