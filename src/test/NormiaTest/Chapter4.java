//package NormiaTest;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.testng.Assert;
//import org.assertj.core.api.SoftAssertions;
//import org.openqa.selenium.WebElement;
//import java.util.concurrent.TimeUnit;
//
//public class Chapter4 {
//
//    private Utils utilsFunction = new Utils();
//
////    private final String userDirProperty = System.getProperty("user.dir");
//    private ChromeDriver chromeDriver
//
//    @BeforeTest
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
//        chromeDriver = new ChromeDriver();
//        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter4");
//    }
//
//    @AfterTest
//    public void tearDown() {
//        chromeDriver.quit();
//    }
//
//    //Elements are displayed
//
//    @Test(description = "First Text Input", priority = 1)
//    public void dateInputTest() {
//        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter4");
//
//        chromeDriver.findElementById("dateInput").sendKeys("Random 123");
//        Assert.assertTrue(chromeDriver.findElementById("dateInput").isDisplayed());
//
//    }
//
//    @Test(description = "Dropdown Menu", priority = 2)
//    public void dropDown() {
//        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter4");
//
//        chromeDriver.findElementById("selecttype").click();
//
//        Select selecttype1 = new Select(chromeDriver.findElementById("selecttype"));
//
//        selecttype1.selectByValue("Selenium IDE");
//        chromeDriver.findElementById("selectLoad").click();
//
//        selecttype1.selectByValue("Selenium Code");
//        chromeDriver.findElementById("selectLoad").click();
//
//        selecttype1.selectByValue("Selenium RC");
//        chromeDriver.findElementById("selectLoad").click();
//
//        selecttype1.selectByValue("Selenium Grid");
//        chromeDriver.findElementById("selectLoad").click();
//
//    }
//}
