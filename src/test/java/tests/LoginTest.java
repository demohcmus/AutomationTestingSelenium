package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        driver.get("http://localhost:9091/login");
        loginPage = new LoginPage(driver);
    }

    // Test case cho đăng nhập thành công
    @Test(priority = 1)
    public void testSuccessfulLogin() {
        // Đăng nhập với thông tin hợp lệ
        loginPage.loginUser("user@gmail.com", "123456");

        Assert.assertTrue(loginPage.isRedirectedToHomePage(), "Đăng nhập thành công nhưng không chuyển hướng đến trang chủ");
        Utils.sleep(8000);

    }

    // Test case cho đăng nhập thất bại với mật khẩu sai
    @Test(priority = 2)
    public void testFailedLoginDueToIncorrectPassword() {
        loginPage.loginUser("user@gmail.com", "abcccccccccccc");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Không hiển thị lỗi khi mật khẩu không chính xác");
        Utils.sleep(8000);
    }
}
