package Scripts;

import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.SearchResultPage;
import Pages.ViewCartPage;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class deleteFromCart extends BaseTest
{
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductDetailPage productDetailPage;
    ViewCartPage viewCartPage;

    @BeforeClass
    public void setUpCart ()
    {
        homePage = new HomePage(driver);
        searchResultPage = homePage.selectCollectionSuccess();
        productDetailPage = searchResultPage.selectProductSuccess();
        viewCartPage = productDetailPage.addToCart();
    }
    @Test
    public void testDeleteFromCart ()
    {
        viewCartPage.deleteFromCart();
        Assert.assertTrue(viewCartPage.isEmptyMessageDisplayed());
        System.out.println("Messaged Displayed");
        viewCartPage.navigateBackToShop();
        Assert.assertEquals(driver.getCurrentUrl(),baseURL, "Navigate Failed");
        System.out.println("Finish Delete Process Success");
    }
}
