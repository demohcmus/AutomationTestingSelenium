package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Đặt thời gian chờ WebDriverWait cho các thao tác
    }

    // Locators cho các trường thông tin đăng ký
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By registerButton = By.cssSelector("button.btn-primary");

    // Locators cho các thông báo lỗi
    private By emailExistsError = By.id("email.errors");  // Thông báo lỗi "Email đã tồn tại"
    private By passwordMismatchError = By.id("confirmPassword.errors");  // Thông báo lỗi "Password nhập không chính xác"

    // Nhập thông tin vào form đăng ký
    public void enterFirstName(String firstName) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField));
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(confirmPassword);
    }

    public void clickRegister() {
        WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerBtn.click();
    }

    // Kiểm tra nếu thông báo lỗi "Email đã tồn tại" xuất hiện
    // Kiểm tra nếu thông báo lỗi "Email đã tồn tại" xuất hiện, sau khi chờ 2 giây
    public boolean isEmailExistsErrorDisplayed() {
        try {
            Thread.sleep(2000);

            return wait.until(ExpectedConditions.visibilityOfElementLocated(emailExistsError)).isDisplayed();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.out.println("Thông báo lỗi 'Email đã tồn tại' không xuất hiện trong thời gian chờ.");
            return false;
        }
    }

    // Kiểm tra nếu thông báo lỗi "Password nhập không chính xác" xuất hiện, sau khi chờ 2 giây
    public boolean isPasswordMismatchErrorDisplayed() {
        try {
            Thread.sleep(2000);  // Chờ 2 giây sau khi nhấn đăng ký
            return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordMismatchError)).isDisplayed();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.out.println("Thông báo lỗi 'Password nhập không chính xác' không xuất hiện trong thời gian chờ.");
            return false;
        }
    }


    // Kiểm tra nếu URL hiện tại là URL chuyển hướng sau khi đăng ký thành công
    public boolean isRedirectedToLoginPage() {
        return driver.getCurrentUrl().equals("http://localhost:9091/login");
    }

    // Phương thức đăng ký đầy đủ
    public void registerUser(String firstName, String lastName, String email, String password, String confirmPassword) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickRegister();
    }
}
