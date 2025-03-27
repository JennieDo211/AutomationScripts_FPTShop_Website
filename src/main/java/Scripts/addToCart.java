package Scripts;

import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.SearchResultPage;
import Pages.ViewCartPage;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addToCart extends BaseTest {
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductDetailPage productDetailPage;
    ViewCartPage viewCartPage;

    //Cách 1: Cách này giúp có thể chạy độc lập từng test -> nhưng sẽ bị lặp lại khi chạy test từ đầu đến cuối.
//    @BeforeMethod
//    public void testSelectCategory ()
//    {
//        homePage = new HomePage(driver);
//        searchResultPage = homePage.selectCollectionSuccess();
//        Assert.assertTrue(searchResultPage.isDisplayed());
//    }
//
//
//    @Test
//    public void testSelectProduct ()
//    {
//        productDetailPage = searchResultPage.selectProductSuccess();
//        Assert.assertTrue(productDetailPage.isDisplayed());
//    }
//
//
//    @Test(dependsOnMethods = {"testSelectProduct"})
//    public void testAddToCart ()
//    {
//        productDetailPage = searchResultPage.selectProductSuccess();
//        productDetailPage.addToCart();
//        Assert.assertTrue(productDetailPage.isAddToCart());
//    }

    //Cách 2: Cách này giúp chạy toàn bộ E2E process mà k bị lặp lại -> Tuy nhiên k thể chạy từng test độc lập
    @Test
    public void testAddToCart ()
    {
        homePage = new HomePage(driver);
        searchResultPage = homePage.selectCollectionSuccess();
        Assert.assertTrue(searchResultPage.isDisplayed());
        productDetailPage = searchResultPage.selectProductSuccess();
        Assert.assertTrue(productDetailPage.isDisplayed());
        String productTitleOnDetailPage = productDetailPage.getProductTitle();
        System.out.println("Product Title on Detail Page: " + productTitleOnDetailPage);
        viewCartPage = productDetailPage.addToCart();
        Assert.assertTrue(productDetailPage.isAddToCart());
        Assert.assertTrue(viewCartPage.isDisplayed());
        String productTitleInCart = viewCartPage.getProductTitleInCart();
        System.out.println("Product Title on View Cart Page: " + productTitleInCart);
        Assert.assertTrue(productTitleInCart.contains(productTitleOnDetailPage), "Product title mismatch between detail page and cart!");
        System.out.println("Product Title Consistency");
        Assert.assertTrue(viewCartPage.isPriceCorrectly());

    }




}
