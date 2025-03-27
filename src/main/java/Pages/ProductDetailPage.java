package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Find Elements
    @FindBy (xpath = "//h1[contains(@class, 'text-textOnWhitePrimary b1-semibold pc:l4-semibold')]")
    WebElement productTitle;
    @FindBy (xpath = "//button[contains(@class,'Button_root__LQsbl Button_btnLarge__N4wc5 Button_redSecondary___XGMX Button_btnSquare___qM_O basis-14')]")
    WebElement addtocartButton;
    @FindBy (xpath = "//a[@href='/gio-hang']//span[@data-cart-count='1']")
    WebElement countInCart;


    // Navigate to Product Detail Page after select product
    public boolean isDisplayed ()
    {
        if (driver.getCurrentUrl().contains("/may-tinh-xach-tay/macbook-pro-m4-pro-14-2024-12cpu-16gpu-24gb-512gb"))
        {
            System.out.println("Navigate to Product Detail Page Success");
            return true;
        } else
        {
            return false;
        }
    }

    // Add to Cart
    public ViewCartPage addToCart() {
        try {
            Actions addtocart = new Actions(driver);
            addtocart.scrollToElement(addtocartButton).perform();
            Thread.sleep(3000);
            addtocart.moveToElement(addtocartButton).click().perform();
            Thread.sleep(5000);
            addtocart.moveToElement(countInCart).perform();
            Thread.sleep(3000);
            addtocart.moveToElement(countInCart).click().perform();
            Thread.sleep(5000);
            return new ViewCartPage(driver);
        } catch (Exception e) {
            System.out.println("That bai 3" + e.getMessage());
        }
        return null;
    }

    public boolean isAddToCart ()
    {
        if (countInCart.isDisplayed())
        {
            System.out.println("Add to Cart Success");
            return true;
        } else
        {
            return false;
        }

    }


    // Prepare to compare Title with ViewCartPage
    public String getProductTitle() {
        return productTitle.getText().trim();
    }
}

