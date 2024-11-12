//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//public class TestClass {
//
//    String homePageLink = "http://localhost:3000/";
//    ChromeDriver chromeDriver;
//
//    @BeforeMethod
//    public void Setup(){
//        System.out.println("Setup method");
//        WebDriverManager.chromedriver().setup();
//        chromeDriver= new ChromeDriver();
//    }
//
//
//
//    @Test
//    public void Run() {
//        System.out.println("Running...");
//        chromeDriver.get(homePageLink);
//        sleep(5000);
//
//
//        WebElement button = chromeDriver.findElement(By.id("btn"));
//
//        button.click();
//        button.clear();
//
//        WebElement statusButton = chromeDriver.findElement(By.id("statusbutton"));
//        String value = statusButton.getText();
//        Assert.assertEquals(value,"Button success", "dung la vay!" );
//
//
//
//        Actions actions = new Actions(chromeDriver);
//        actions.moveToElement(button);
//
//        actions.click(button).build().perform();
//        actions.sendKeys(button, "abc").build().perform();;
//        sleep(1000);
//
//    }
//
//    @Test
//    public void Run2() {
//        System.out.println("Running...");
//        chromeDriver.get(homePageLink);
//        sleep(1000);
//        WebElement element = chromeDriver.findElement(By.id("txt"));
//        element.sendKeys("1233iii");
//        sleep(1000);
//        String actual = getText(element);
//
//        Assert.assertEquals(actual, "1233");
//
//
//
//    }
//
//    public String getText(WebElement element){
//        return element.getAttribute("value");
//    }
//
//    @AfterMethod
//    public void CleanUp(){
//        System.out.printf("After method");
//        chromeDriver.quit();
//    }
//
//    private void sleep(int time){
//        try{
//            Thread.sleep(time);
//        } catch (Exception ex){
//            System.out.printf(ex.getMessage());
//
//        }
//    }
////    public static void main(String[] args) {
////        TestClass test = new TestClass();
////        test.Run();
////    }
//}
