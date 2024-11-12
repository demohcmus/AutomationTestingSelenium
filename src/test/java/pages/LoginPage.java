package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By emailField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button.btn-primary");
    private By errorMessage = By.xpath("//div[contains(text(), 'Invalid email or password')]");

    // Nhập email
    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    // Nhập mật khẩu
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    // Nhấn nút đăng nhập
    public void clickLogin() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

    public boolean isRedirectedToHomePage() {
        return wait.until(ExpectedConditions.urlToBe("http://localhost:9091/"));
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return errorElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Phương thức đăng nhập hoàn chỉnh
    public void loginUser(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
