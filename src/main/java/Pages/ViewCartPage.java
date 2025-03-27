package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewCartPage {
    WebDriver driver;
    WebDriverWait wait;
    public ViewCartPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Finds Elements
    @FindBy (xpath = "//div[contains(@class,'gap-y-4 bg-bgWhiteDefault pc:rounded-[12px]')]//span[@title='MacBook Pro 14 M4 Pro 2024 12CPU/16GPU/24GB/512GB Đen MX2H3SA/A']")
    WebElement productTitleinCart;
    @FindBy (xpath = "//span[contains(text(), '49.990.000') and contains(text(), '₫')]")
    WebElement priceinCart;
    @FindBy (xpath = "(//div[contains(text(), '49.990.000') and contains(text(), '₫')])[1]")
    WebElement priceinSummaryCard;
    @FindBy (xpath = "//div[contains(@class, 'b1-medium text-textOnWhitePrimary') and contains(text(), '0 ₫')] ")
    WebElement promotion;
    @FindBy (xpath = "(//div[contains(text(), '49.990.000') and contains(text(), '₫')])[2]")
    WebElement finalPrice;

    // Navigate to View Cart Page
    public boolean isDisplayed ()
    {
        if (driver.getCurrentUrl().contains("/gio-hang"))
        {
            System.out.println("Navigate to View Cart Page Success");
            return true;
        } else
        {
            return false;
        }
    }

    // Verify product Title consistency
    public String getProductTitleInCart()
    {
        return productTitleinCart.getText().trim();
    }

    // Get Text from Element
    private String getTextfromElement(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();
        } catch (Exception e) {
            System.out.println("⚠️ Warning: Unable to retrieve text from element: " + element);
            return ""; // Return empty string if element is not found
        }
    }

    // Convert Price from String to int
    private int parsePrice(String priceText) {
        return Integer.parseInt(priceText.replace(".", "").replace(" ₫", "").trim());
    }

    // Verify Price is Count correctly
    public boolean isPriceCorrectly ()
    {
        String cartPrice = getTextfromElement(priceinCart);
        String summaryPrice = getTextfromElement(priceinSummaryCard);
        String promo = getTextfromElement(promotion);
        String finalTotal = getTextfromElement(finalPrice);

        System.out.println("Price in Cart: " + cartPrice);
        System.out.println("Summary Price: " + summaryPrice);
        System.out.println("Promotion: " + promo);
        System.out.println("Final Price" + finalTotal);

        // Verify price consistency between Cart and Summary Card
        if (!cartPrice.equals(summaryPrice))
        {
            System.out.println("Price inconsistency");
        }

        // Verify system count finalTotal correctly
        if (promo.equals("0 ₫"))
        {
            boolean isPriceCorrectWithNoPromo = summaryPrice.equals(finalTotal);
            System.out.println("Price is display correctly: " + isPriceCorrectWithNoPromo);
            return isPriceCorrectWithNoPromo;
        } else
        {
            int summaryPriceValue = parsePrice(summaryPrice);
            int promoValue = parsePrice(promo);
            int expectedFinalPrice = summaryPriceValue - promoValue;
            int finalPriceValue = parsePrice(finalTotal);
            boolean isPriceCorrectWithPromo = (expectedFinalPrice == finalPriceValue);
            System.out.println("Price is displayed correctly: " + isPriceCorrectWithPromo);
            return isPriceCorrectWithPromo;
        }
    }








}
