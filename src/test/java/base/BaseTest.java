package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Khởi động WebDriver Manager để tải và quản lý phiên bản ChromeDriver tự động
        WebDriverManager.chromedriver().setup();

        // Thiết lập Chrome Options (nếu cần)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Mở trình duyệt ở chế độ toàn màn hình
        options.addArguments("--disable-notifications"); // Tắt thông báo nếu có

        // Khởi tạo driver cho trình duyệt Chrome
        driver = new ChromeDriver(options);

        // Thiết lập thời gian chờ mặc định
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Thiết lập thời gian chờ mặc định là 10 giây
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Đóng trình duyệt sau mỗi lần kiểm thử
        }
    }
}

