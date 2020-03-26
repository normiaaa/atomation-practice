package NormiaTest;

import Pages.Chapter2Page;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Chapter2 {

    public Utility utils = new Utility();

    private final String userDirProperty = System.getProperty("user.dir");
    private ChromeDriver chromeDriver;

    Chapter2Page ch2p;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
        chromeDriver.get(utils.URL_CHAPTER2);
    }

        @BeforeTest
        public void setup () {
            System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
            chromeDriver = new ChromeDriver();
            chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            chromeDriver.get(utils.URL_CHAPTER2);
            ch2p = new Chapter2Page(this.chromeDriver);
        }

    @AfterTest
    public void tearDown() {
        chromeDriver.quit();
    }

    //Elements are displayed

    @Test(description = "Buttons", priority = 1)
    public void contentTest() {
       // chromeDriver.get("http://book.theautomatedtester.co.uk/chapter2");

        //1st button

        ch2p.clickOnButtonWithName();
        ch2p.checkButtonWithNameText();

        //2nd button

        ch2p.clickOnRandomButton();
        ch2p.checkRandomButtonText();

        //3rd button

        ch2p.clickOnButtonWithID();
        ch2p.checknButtonWithIDText();

        //4th button

        ch2p.clickOnSiblingButton();
        ch2p.checkSiblingButtonText();


        //5th button

        ch2p.clickOnVerifyButton();
        ch2p.checkVerifyButtonText();

        //6th button

        ch2p.clickOnChocolateButton();
        ch2p.checkChocolateButtonText();
    }

}
