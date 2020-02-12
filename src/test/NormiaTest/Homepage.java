package NormiaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Homepage {

    private Utils utilsFunction = new Utils();

    private final String userDirProperty = System.getProperty("user.dir");
    private ChromeDriver chromeDriver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("http://book.theautomatedtester.co.uk/");
    }

    @AfterTest
    public void tearDown() {
        chromeDriver.quit();
    }

    // @Test -> to be continued



    }



