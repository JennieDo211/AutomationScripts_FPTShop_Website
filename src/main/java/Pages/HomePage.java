package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Find Elements
    private By collectionField = By.xpath("//div[contains(@class,'Category_navigation__vm3vC')]");
    private By appleCollection = By.xpath("//li[contains(@class, 'listMenu')]//a[text() = 'Chuyên trang Apple']");
    private By macbookProducts = By.xpath("//a[contains(@class,'text-link') and text() ='MacBook']");

    // Select Product
    public void selectCollection() {
        try {
            Actions select = new Actions(driver);
            WebElement collection = driver.findElement(collectionField);
            select.moveToElement(collection).perform();
            Thread.sleep(3000);
            WebElement apple = wait.until(ExpectedConditions.visibilityOfElementLocated(appleCollection));
            select.moveToElement(apple).perform();
            Thread.sleep(3000);
            WebElement macbook = wait.until(ExpectedConditions.elementToBeClickable(macbookProducts));
            Thread.sleep(3000);
            select.moveToElement(macbook).click().perform();
        } catch (Exception e)
        {
            System.out.println("That bai 1" + e.getMessage());
        }
    }

    public boolean isSelectedCategory ()
    {
        if (driver.getCurrentUrl().contains("/apple/macbook"))
        {
            return true;
        } else
        {
            return false;
        }
    }
}

