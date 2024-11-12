package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductFilterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ProductFilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By dellCheckbox = By.id("factory-4");
    private By targetCheckbox = By.id("target-2");
    private By priceCheckbox = By.id("price-4");
    private By filterButton = By.id("btnFilter");
    private By filteredProduct = By.xpath("//a[contains(text(), 'Laptop Dell Inspiron 15')]");

    // Chọn bộ lọc "DELL"
    public void selectDellFilter() {
        WebElement dell = wait.until(ExpectedConditions.elementToBeClickable(dellCheckbox));
        if (!dell.isSelected()) {
            dell.click();
        }
    }

    // Chọn bộ lọc "Sinh viên - văn phòng"
    public void selectTargetFilter() {
        WebElement target = wait.until(ExpectedConditions.elementToBeClickable(targetCheckbox));
        if (!target.isSelected()) {
            target.click();
        }
    }

    // Chọn bộ lọc "Từ 15 - 20 triệu"
    public void selectPriceFilter() {
        WebElement price = wait.until(ExpectedConditions.elementToBeClickable(priceCheckbox));
        if (!price.isSelected()) {
            price.click();
        }
    }

    // Nhấn nút "Lọc Sản Phẩm" bằng cách cuộn đến nó và sử dụng JavaScript nếu cần
    public void clickFilterButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(filterButton));

        // Cuộn đến nút nếu chưa hiển thị hoàn toàn trên màn hình
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        // Sử dụng JavaScript để nhấp vào nút
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    // Kiểm tra xem sản phẩm đã lọc có hiển thị hay không
    public boolean isFilteredProductDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(filteredProduct));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
