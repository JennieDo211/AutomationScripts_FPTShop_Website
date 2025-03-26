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

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;
    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Find Elements
    @FindBy(xpath = "(//a[@href='/may-tinh-xach-tay/macbook-pro-m4-pro-14-2024-12cpu-16gpu-24gb-512gb'])[1]")
    WebElement product;

    // Navigation to SearchResultPage after select Category
    public boolean isDisplayed ()
    {
        if (driver.getCurrentUrl().contains("/apple/macbook"))
        {
            System.out.println("Navigate to Search Result Page Success");
            return true;
        } else
        {
            return false;
        }
    }

    // Perform Select Product
    public ProductDetailPage selectProductSuccess ()
    {
        try {
            Actions selectProduct = new Actions(driver);
            selectProduct.scrollToElement(product).perform();
            Thread.sleep(5000);
            selectProduct.moveToElement(product).click().perform();
            Thread.sleep(5000);
            return new ProductDetailPage(driver);
        } catch (Exception e)
        {
            System.out.println("That bai 2" + e.getMessage());
            return null;
        }
    }

}
