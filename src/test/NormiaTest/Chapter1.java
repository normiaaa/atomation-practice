package NormiaTest;

import Pages.Chapter1Page;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class Chapter1 extends TestClassParent {


    Chapter1Page ch1p;



    @Parameters({"pageIndex"})
    @BeforeClass
    public void beforeClass(@Optional("1") final int i) {
       this.pageIndex=i;
        System.out.println("VALUEEE >> " + pageIndex);
    }


    @BeforeMethod(groups = {"display_elements"})
    public void setup() {

        super.beforeMethod();
        ch1p = new Chapter1Page(driver);

    }

    @AfterMethod(groups = {"display_elements"})
    public void teardown() {

        super.afterMethod();

    }


    //Test 1: Check if elements are displayed

    @Test(description = "Display Elements", priority = 1, groups = {"display_elements"})
    public void contentTest(ITestContext context) {

        //Check title
        ch1p.checkTitle();
        ch1p.checkIfButtonIsDisplayed();

    }

    //Test 2: Check if the Radio Button is checked correctly and Select items from the DropDown menu works accordingly

    @Test(description = "Radio Button and List", priority = 2, groups = { "display_elements"})
    public void radioButtonListTest() throws InterruptedException {

        ch1p.clickOnRadioButton();
        ch1p.selectItemsFromDropdown();
        ch1p.selectSpecificItemFromDropdown(utils.SELECT_SELENIUM_VALUE2);

    }

    //Test 3: Check if the links are opened correctly

    @Test(description = "Links", priority = 3)
    public void links() throws InterruptedException {
        driver.get(utils.URL_CHAPTER1);

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

    //Test 4: Check load text elements

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



