package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class ProductDetailsTest extends BaseTest {

    private ProductDetailsPage productDetailsPage;

    @BeforeMethod
    public void setUpPage() {
        productDetailsPage = new ProductDetailsPage(driver);
        driver.get("http://localhost:9091");
    }

    // Test case để kiểm tra xem chi tiết sản phẩm
    @Test(priority = 1)
    public void testViewProductDetails() {
        WebElement productLink = driver.findElement(By.linkText("Laptop Asus TUF Gaming"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productLink);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:9091/product/1"));

        Assert.assertTrue(productDetailsPage.isDescriptionTabDisplayed(), "Tab 'Description' không hiển thị.");
        Assert.assertTrue(productDetailsPage.isDescriptionContentDisplayed(), "Nội dung mô tả sản phẩm không hiển thị chính xác.");
        Utils.sleep(8000);
    }
}
