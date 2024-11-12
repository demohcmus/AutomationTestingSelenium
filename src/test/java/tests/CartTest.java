package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import utils.Utils;

import java.time.Duration;

public class CartTest extends BaseTest {

    private CartPage cartPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        driver.get("http://localhost:9091/login");
    }

    // Test case để kiểm tra thêm sản phẩm vào giỏ hàng thành công
    @Test(priority = 1)
    public void testAddProductToCart() {
        loginPage.loginUser("user@gmail.com", "123456");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:9091/"));

        cartPage.clickAddToCartButton();

        Utils.sleep(3000);
        driver.get("http://localhost:9091/cart");
        Utils.sleep(3000);

        Assert.assertTrue(cartPage.isProductNameDisplayed(), "Tên sản phẩm không hiển thị trong giỏ hàng.");
        Assert.assertTrue(cartPage.isProductPriceDisplayed(), "Giá sản phẩm không hiển thị trong giỏ hàng.");
        Assert.assertTrue(cartPage.isProductQuantityDisplayed(), "Số lượng sản phẩm không hiển thị trong giỏ hàng.");
        Utils.sleep(8000);

    }
}
