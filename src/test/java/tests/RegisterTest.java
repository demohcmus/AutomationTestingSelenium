package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.Utils;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    private RegisterPage registerPage;

    @BeforeMethod
    public void setUpPage() {
        driver.get("http://localhost:9091/register");  // URL trang đăng ký
        registerPage = new RegisterPage(driver);
    }

    // Test case cho đăng ký thành công
    @Test(priority = 1)
    public void testSuccessfulRegistration() {
        // Thực hiện đăng ký với thông tin hợp lệ
        registerPage.registerUser("Le", "Ngo", "newUser1@gmail.com", "Password123!", "Password123!");

        // Chờ và kiểm tra nếu chuyển hướng tới trang đăng nhập trong vòng 10 giây
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isRedirected = wait.until(ExpectedConditions.urlToBe("http://localhost:9091/login"));

        Assert.assertTrue(isRedirected, "Đăng ký thành công nhưng không chuyển hướng đến trang đăng nhập");
        Utils.sleep(8000);

    }

    // Test case cho trường hợp email đã tồn tại
    @Test(priority = 2)
    public void testEmailAlreadyExists() {
        registerPage.registerUser("Le", "Ngo", "user@gmail.com", "123456789", "123456789!");

        // Kiểm tra nếu hiển thị thông báo lỗi "Email đã tồn tại"
        Assert.assertTrue(registerPage.isEmailExistsErrorDisplayed(), "Không hiển thị lỗi khi email đã tồn tại");
        Utils.sleep(8000);
    }

    // Test case cho trường hợp xác nhận mật khẩu không khớp
    @Test(priority = 3)
    public void testPasswordMismatch() {
        registerPage.registerUser("Dung", "Le", "newUser2@gmail.com", "123456789", "WrongPassword");

        // Kiểm tra nếu hiển thị thông báo lỗi "Password nhập không chính xác"
        Assert.assertTrue(registerPage.isPasswordMismatchErrorDisplayed(), "Không hiển thị lỗi khi mật khẩu xác nhận không khớp");
        Utils.sleep(8000);
    }
}
