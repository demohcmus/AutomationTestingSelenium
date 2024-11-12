package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import java.time.Duration;

public class LogoutTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);

        // Điều hướng tới trang đăng nhập
        driver.get("http://localhost:9091/login");

        // Đăng nhập
        loginPage.loginUser("user@gmail.com", "123456");

        // Chờ điều hướng đến trang chủ sau khi đăng nhập
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:9091/"));
        Utils.sleep(3000);

    }

    // Test case để kiểm tra chức năng đăng xuất
    @Test(priority = 1)
    public void testLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Nhấp vào dropdown tài khoản
        WebElement dropdownMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuLink")));

        // Sử dụng JavaScript để đảm bảo dropdown có thể nhấp
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownMenu);

        // Nhấn vào nút "Đăng xuất" trong dropdown form
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Đăng xuất')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutButton);

        // Kiểm tra điều hướng đến trang đăng nhập và hiển thị thông báo "Logout success."
        wait.until(ExpectedConditions.urlToBe("http://localhost:9091/login?logout"));

        // Kiểm tra sự xuất hiện của thông báo thành công
        WebElement logoutSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Logout success.')]")));
        Assert.assertTrue(logoutSuccessMessage.isDisplayed(), "Thông báo 'Logout success.' không hiển thị.");
        Utils.sleep(8000);
    }
}
