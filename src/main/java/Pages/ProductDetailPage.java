package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Find Elements
    private By addtocartButton = By.xpath("//button[contains(@class,'Button_root__LQsbl Button_btnLarge__N4wc5 Button_redSecondary___XGMX Button_btnSquare___qM_O basis-14')]");
    private By countInCart = By.xpath("//a[@href='/gio-hang']//span[@data-cart-count='1']");

    // Add to Cart
    public void addToCart() {
        try {
            Actions addtocart = new Actions(driver);
            WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addtocartButton));
            addtocart.scrollToElement(addButton).perform();
            Thread.sleep(3000);
            addtocart.moveToElement(addButton).click().perform();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("That bai 3" + e.getMessage());
        }
    }

    public boolean isAddToCart ()
    {
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(addtocartButton));
        if (cart.isDisplayed())
        {
            return true;
        } else
        {
            return false;
        }

    }
}

