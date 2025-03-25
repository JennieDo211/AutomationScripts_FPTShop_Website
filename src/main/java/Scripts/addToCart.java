package Scripts;

import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.SearchResultPage;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addToCart extends BaseTest {
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductDetailPage productDetailPage;
    @BeforeMethod
    public void testSelectCategory ()
    {
        homePage = new HomePage(driver);
        homePage.selectCollection();
    }

    @Test
    public void testNavigationAfterCategorySelected ()
    {
        Assert.assertTrue(homePage.isSelectedCategory());
    }

    @Test
    public void testSelectProduct ()
    {
        searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.isProductSelected());
    }

    @Test
    public void testAddToCart ()
    {
        productDetailPage = new ProductDetailPage(driver);
        Assert.assertTrue(productDetailPage.isAddToCart());
    }




}
