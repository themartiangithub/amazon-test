package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class AmazonTest extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void SetUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void test1() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell Laptop");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.RETURN);
        clickOnElement(By.id("sp-cc-accept"));
        clickOnElement(By.xpath("//li[@id = 'p_89/Dell']//i[@class = 'a-icon a-icon-checkbox']"));
        List<WebElement> items = getListOfElements(By.xpath("//div[@class = 'a-section a-spacing-none puis-padding-right-small s-title-instructions-style']"));
        System.out.println("Total Products on page are " + items.size());
        for (WebElement item : items) {
            System.out.println(item.getText());
        }
        clickOnElement(By.xpath("//span[contains(text(),'Dell Latitude 7490 14” FHD Laptop – Core i7-8650U ')]"));


    }

    @After
    public void TearDown() {
        closeBrowser();
    }
}
