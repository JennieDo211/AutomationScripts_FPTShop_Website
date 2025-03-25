package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;
    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Find Elements
    private By product = By.xpath("(//a[@href='/may-tinh-xach-tay/macbook-pro-m4-pro-14-2024-12cpu-16gpu-24gb-512gb'])[1]");
//    private By addtocartButton = By.xpath("//button[contains(@class,'Button_root__LQsbl Button_btnLarge__N4wc5 Button_redSecondary___XGMX Button_btnSquare___qM_O basis-14')]");

    // Perform Select Product
    public void selectProduct ()
    {
        try {
            Actions selectProduct = new Actions(driver);
            WebElement productSelected = wait.until(ExpectedConditions.visibilityOfElementLocated(product));
            selectProduct.scrollToElement(productSelected).perform();
            Thread.sleep(5000);
            selectProduct.moveToElement(productSelected).click().perform();
            Thread.sleep(5000);
//            WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addtocartButton));
//            addtocart.scrollToElement(addButton).perform();
//            Thread.sleep(3000);
//            addtocart.moveToElement(addButton).click().perform();
//            Thread.sleep(5000);
        } catch (Exception e)
        {
            System.out.println("That bai 2" + e.getMessage());
        }
    }

    public boolean isProductSelected ()
    {
        if (driver.getCurrentUrl().contains("/may-tinh-xach-tay/macbook-pro-m4-pro-14-2024-12cpu-16gpu-24gb-512gb"))
        {
            return true;
        } else
        {
            return false;
        }
    }
}
