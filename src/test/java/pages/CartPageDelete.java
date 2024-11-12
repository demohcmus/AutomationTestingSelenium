package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPageDelete {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPageDelete(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator cho nút xóa sản phẩm khỏi giỏ hàng
    private By deleteButton = By.cssSelector("button.btn-md.rounded-circle.bg-light.border.mt-4");

    // Locator kiểm tra sự tồn tại của sản phẩm trong giỏ hàng
    private By productRow = By.xpath("//tr[th[@scope='row'] and td//a[contains(text(), 'Laptop Asus TUF Gaming')]]");

    // Phương thức nhấn nút xóa
    public void clickDeleteButton() {
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteBtn.click();
    }

    // Phương thức kiểm tra giỏ hàng có trống không (sản phẩm không tồn tại)
    public boolean isCartEmpty() {
        // Sử dụng WebDriverWait để chờ và xác minh rằng sản phẩm không còn hiển thị trên trang
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(productRow));
            return true;  // Giỏ hàng trống
        } catch (Exception e) {
            return false; // Giỏ hàng vẫn có sản phẩm
        }
    }
}

