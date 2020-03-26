package NormiaTest;

import Pages.Chapter1Page;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;



public class Chapter1{


    private final String userDirProperty = System.getProperty("user.dir");
    private ChromeDriver chromeDriver;
    public Utility utils = new Utility();



    Chapter1Page ch1p;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
        chromeDriver.get(utils.URL_CHAPTER1);

        //I found this method - to get the URL before each method. is this ok? or?
    }

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get(utils.GENERAL_URL);
        ch1p = new Chapter1Page(this.chromeDriver);
    }

    @AfterTest
    public void tearDown() {
        chromeDriver.quit();
    }

    //Elements are displayed

    @Test(description = "Display Elements", priority = 1)
    public void contentTest() {

        //Check title
        ch1p.checkTitle();
        ch1p.checkIfButtonIsDisplayed();

    }

    @Test(description = "Radio Button and List", priority = 2)
    public void radioButtonListTest() throws InterruptedException {

        ch1p.clickOnRadioButton();
        ch1p.selectItemsFromDropdown();
        ch1p.selectSpecificItemFromDropdown(utils.SELECT_SELENIUM_VALUE2);


        //I made this by Value text, it should be more ok by index?
    }

    @Test(description = "Links", priority = 3)
    public void links() throws InterruptedException {
//        chromeDriver.get(utils.URL_CHAPTER1);

        //Open the first Window

        ch1p.clickOnNewWindow1();
        ch1p.checkNewWindow1();

        //Open the second window

        ch1p.openNewWindow2();
        ch1p.checkNewWindow2();

        //Load a page with Ajax

        ch1p.clickFirstAjaxElement();
        ch1p.checkFirstAjaxElement();


    }

    @Test(description = "Radio Button and List", priority = 4)
    public void loadText() throws InterruptedException {

        //Find second ajax button and click on it

        ch1p.clickSecondAjaxElement();
        ch1p.checkSecondAjaxElement();

    }


    public void title() {

        ch1p.checkTitle();


    }
}



