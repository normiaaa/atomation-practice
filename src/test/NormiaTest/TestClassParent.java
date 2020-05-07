package NormiaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class TestClassParent implements TestClassParentInterface {


    private final String userDirProperty = System.getProperty("user.dir");
    public Utility utils = new Utility();


    WebDriver driver;


    @Override
    public void beforeMethod() {
        System.out.println("BeforeMethod");
        driver.get(utils.URL_CHAPTER1);

    }


    @AfterTest
    public void tearDown() {
        this.afterTest();
    }


    @Override
    public void afterMethod() {

    }

    @Override
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Override
    public void afterTest() {
        driver.quit();
    }
}