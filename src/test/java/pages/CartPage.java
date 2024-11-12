package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By productName = By.xpath("//a[contains(text(),'Laptop Asus TUF Gaming')]");
    private By productPrice = By.xpath("//td/p[contains(text(),'17,490,000 đ')]");
    private By productQuantity = By.xpath("//input[@class='form-control form-control-sm text-center border-0' and @value='1']");
    private By addToCartButton = By.cssSelector("button.mx-auto.btn.border.border-secondary.rounded-pill.px-3.text-primary");

    // Phương thức kiểm tra sự hiện diện của tên sản phẩm
    public boolean isProductNameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).isDisplayed();
    }

    // Phương thức kiểm tra sự hiện diện của giá sản phẩm
    public boolean isProductPriceDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).isDisplayed();
    }

    // Phương thức kiểm tra sự hiện diện của số lượng sản phẩm
    public boolean isProductQuantityDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity)).isDisplayed();
    }

    // Cuộn đến và nhấn vào nút "Add to Cart" nếu cần
    public void clickAddToCartButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        // Cuộn đến nút nếu chưa hiển thị hoàn toàn trên màn hình
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        // Chờ thêm một chút để đảm bảo cuộn hoàn tất
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sử dụng JavaScript để nhấp vào nút
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

        // Đợi thêm một chút để đảm bảo nút được nhấp và quá trình thêm sản phẩm vào giỏ hàng hoàn tất
        try {
            Thread.sleep(1000);  // Tăng thời gian nếu cần chờ lâu hơn
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
