package NormiaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestClassParent {


    private final String userDirProperty = System.getProperty("user.dir");
    public Utility utils = new Utility();


    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
        driver.get(utils.URL_CHAPTER1);

    }

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
