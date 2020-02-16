package NormiaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class Chapter2 {

    private Utils utilsFunction = new Utils();

    private final String userDirProperty = System.getProperty("user.dir");
    private ChromeDriver chromeDriver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter2");
    }

    @AfterTest
    public void tearDown() {
        chromeDriver.quit();
    }

    //Elements are displayed

    @Test(description = "Buttons", priority = 1)
    public void contentTest() {
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter2");

        //1st button

        chromeDriver.findElementByName("but2").click();
        Assert.assertTrue(chromeDriver.findElementByName("but2").getAttribute("value").contains("Button with name"));

        //2nd button

        chromeDriver.findElementByCssSelector ("[value='Random']").click();
        Assert.assertTrue(chromeDriver.findElementByCssSelector ("[value='Random']").getAttribute("value").contains("Random"));

        //3rd button

        chromeDriver.findElementById("but1").click();
        Assert.assertTrue(chromeDriver.findElementById("but1").getAttribute("value").contains("Button with ID"));

        //4th button

        chromeDriver.findElementByName("verifybutton").click();
        Assert.assertTrue(chromeDriver.findElementByName("verifybutton").getAttribute("value").contains("Verify this button\n" +
                "                 here"));

        //5th button

        chromeDriver.findElementByName("verifybutton1").click();
        Assert.assertTrue(chromeDriver.findElementByName("verifybutton1").getAttribute("value").contains("chocolate"));

    }

}
