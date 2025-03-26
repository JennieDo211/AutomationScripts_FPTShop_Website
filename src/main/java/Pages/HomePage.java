package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Find Elements
    @FindBy(xpath = "//div[contains(@class,'Category_navigation__vm3vC')]")
    WebElement collectionField;
    @FindBy(xpath = "//li[contains(@class, 'listMenu')]//a[text() = 'Chuyên trang Apple']")
    WebElement appleCollection;
    @FindBy(xpath = "//a[contains(@class,'text-link') and text() ='MacBook']")
    WebElement macbookProducts;

    // Select Product
    public SearchResultPage selectCollectionSuccess()
    {
        try {
            Actions select = new Actions(driver);
            select.moveToElement(collectionField).perform();
            Thread.sleep(3000);
            select.moveToElement(appleCollection).perform();
            Thread.sleep(5000);
            select.moveToElement(macbookProducts).click().perform();
            Thread.sleep(3000);
            return new SearchResultPage(driver);
        } catch (Exception e) {
            System.out.println("That bai 1" + e.getMessage());
            return null;
        }
    }
}

