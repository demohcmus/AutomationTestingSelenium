package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductFilterPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class ProductFilterTest extends BaseTest {

    private ProductFilterPage productFilterPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);
        productFilterPage = new ProductFilterPage(driver);

        driver.get("http://localhost:9091/login");

        // Đăng nhập
        loginPage.loginUser("user@gmail.com", "123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:9091/"));
        Utils.sleep(5000);

        // Điều hướng tới trang sản phẩm
        driver.get("http://localhost:9091/products");
    }

    // Test case để kiểm tra chức năng lọc sản phẩm
    @Test(priority = 1)
    public void testProductFilter() {
        Utils.sleep(3000);

        productFilterPage.selectDellFilter();
        productFilterPage.selectTargetFilter();
        productFilterPage.selectPriceFilter();

        productFilterPage.clickFilterButton();

        // Kiểm tra xem kết quả lọc có sản phẩm mong muốn hay không
        Assert.assertTrue(productFilterPage.isFilteredProductDisplayed(), "Sản phẩm 'Laptop Dell Inspiron 15' không hiển thị sau khi lọc.");
        Utils.sleep(8000);
    }
}
