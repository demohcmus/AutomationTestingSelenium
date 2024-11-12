package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By descriptionTab = By.id("nav-about-tab");
    private By descriptionContent = By.xpath("//div[@id='nav-about']//p[contains(text(), 'ASUS TUF Gaming F15 FX506HF HN017W')]");

    // Kiểm tra nếu tab "Description" hiển thị
    public boolean isDescriptionTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionTab)).isDisplayed();
    }

    // Kiểm tra nếu nội dung mô tả sản phẩm hiển thị đúng
    public boolean isDescriptionContentDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionContent)).isDisplayed();
    }
}
