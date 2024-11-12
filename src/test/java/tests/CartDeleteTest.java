package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CartPageDelete;
import pages.LoginPage;
import utils.Utils;

import java.time.Duration;

public class CartDeleteTest extends BaseTest {

    private CartPageDelete cartPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {

        loginPage = new LoginPage(driver);
        cartPage = new CartPageDelete(driver);
        driver.get("http://localhost:9091/login");
    }

    // Test case xóa sản phẩm khỏi giỏ hàng
    @Test(priority = 1)
    public void testRemoveProductFromCart() {

        loginPage.loginUser("user@gmail.com", "123456");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:9091/"));
        Utils.sleep(3000);
        driver.get("http://localhost:9091/cart");
        Utils.sleep(3000);
        cartPage.clickDeleteButton();

        // Chờ và kiểm tra xem giỏ hàng có trống không sau khi xóa
        Assert.assertTrue(cartPage.isCartEmpty(), "Giỏ hàng không trống sau khi xóa sản phẩm.");
        Utils.sleep(10000);
    }
}
