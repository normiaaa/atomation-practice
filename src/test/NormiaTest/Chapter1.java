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


public class Chapter1 {

    private Utils utilsFunction = new Utils();

    private final String userDirProperty = System.getProperty("user.dir");
    private ChromeDriver chromeDriver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("http://book.theautomatedtester.co.uk");
    }

    @AfterTest
    public void tearDown() {
        chromeDriver.quit();
    }

    //Elements are displayed

    @Test(description = "Display Elements", priority = 1)
    public void contentTest() {
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter1");
        Assert.assertTrue(chromeDriver.getTitle().contains("Selenium: Beginners Guide"));
        chromeDriver.findElementById("verifybutton").isDisplayed();
        Assert.assertTrue(chromeDriver.findElementById("divontheleft").getText().contains("Assert that this text is on the page"));

    }

    @Test(description = "Radio Button and List", priority = 2)
    public void radioButtonListTest() throws InterruptedException {
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter1");
        chromeDriver.findElementById("radiobutton").click();
        chromeDriver.findElementById("selecttype").click();

        Select selecttype1 = new Select(chromeDriver.findElementById("selecttype"));
        selecttype1.selectByValue("Selenium IDE");
        selecttype1.selectByValue("Selenium Code");
        selecttype1.selectByValue("Selenium RC");
        selecttype1.selectByValue("Selenium Grid");

        chromeDriver.findElementById("selecttype").click();

        chromeDriver.findElementByName("selected(1234)").click();


        //I made this by Value text, it should be more ok by index?
    }

    @Test(description = "Linkst", priority = 3)
    public void links() throws InterruptedException {
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter1");

        //First Window

        chromeDriver.findElementByClassName("multiplewindow").click();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(chromeDriver.findElementByClassName("multiplewindow").getAttribute("href")).isEqualTo("http://book.theautomatedtester.co.uk/windowpopup.html");

        //Second Window

        chromeDriver.findElementByClassName("multiplewindow2").click();
        softAssertions.assertThat(chromeDriver.findElementByClassName("multiplewindow2").getAttribute("href")).isEqualTo("http://book.theautomatedtester.co.uk/windowpopup.html");

        //Load a page with Ajax

        chromeDriver.findElementByClassName("loadajax").click();
        softAssertions.assertThat(chromeDriver.findElementByClassName("loadajax").getAttribute("href")).contains("The following text has been loaded from another page on this site. It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter");


    }

    @Test(description = "Radio Button and List", priority = 4)
    public void loadText() throws InterruptedException {
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter1");
        chromeDriver.findElementById("secondajaxbutton").click();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(chromeDriver.findElementById("secondajaxbutton").getAttribute("href")).contains("I have been added with a timeout");

    }
}



