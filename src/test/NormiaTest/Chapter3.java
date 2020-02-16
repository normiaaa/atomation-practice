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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Chapter3 {

    private Utils utilsFunction = new Utils();

    private final String userDirProperty = System.getProperty("user.dir");
    private ChromeDriver chromeDriver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter3");
    }

    @AfterTest
    public void tearDown() {
        chromeDriver.quit();
    }

    //Elements are displayed

    @Test(description = "Buttons", priority = 1)
    public void contentTest() {
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter3");

        //1st Text

        chromeDriver.findElementById("divinthecenter").click();
        Assert.assertTrue(chromeDriver.findElementById("divinthecenter").getText().equals("Virgo Cancer Capricorn'"));

        //2nd Text

        chromeDriver.findElementById("leftdiv").click();
        Assert.assertTrue(chromeDriver.findElementById("leftdiv").getText().contains("ool"));

        //The text is changing after each refresh in this situation. I decided to test this using the above method -> is there a better way to do this?
        //I saw that there are 4 variations of words, each one containing "ool". I have not found any methods online on how to test text which changes
        //after each refresh?

        //Current date method


        Date now = new Date();
        String str1 = "EEE dd MMM yyyy";

        SimpleDateFormat dateFormat = new SimpleDateFormat(str1, Locale.US);
        Assert.assertTrue(chromeDriver.findElementById("centerdiv").getText().equals(dateFormat.format(now)));


    }
}
