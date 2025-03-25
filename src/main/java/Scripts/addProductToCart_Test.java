package Scripts;

import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.SearchResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class addProductToCart_Test {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        try {
            driver.get("https://fptshop.com.vn/");

            // Select Category
            HomePage homePage = new HomePage(driver);
            homePage.selectCollection();
            System.out.println("Select Thanh Cong");

            // Test Select Category
            

            // Select Product to add to Cart
            SearchResultPage searchResultPage = new SearchResultPage(driver);
            searchResultPage.selectProduct();
            if (driver.getCurrentUrl().contains("macbook-pro-m4-pro-14-2024-12cpu-16gpu-24gb-512gb")) {
                System.out.println("Select Thanh Cong");
            } else {
                System.out.println("Select That Bai");
            }

            // Add to cart
            ProductDetailPage productDetailPage = new ProductDetailPage(driver);
            productDetailPage.addToCart();
            if (driver.getCurrentUrl().contains("macbook-pro-m4-pro-14-2024-12cpu-16gpu-24gb-512gb")) {
                System.out.println("Add to Cart Thanh Cong");
            } else {
                System.out.println("Add to Cart That Bai");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            driver.quit();
        }


        }
    }
