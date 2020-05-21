package NormiaTest;

import Pages.Chapter2Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Chapter2 extends TestClassParent {

    public Utility utils = new Utility();

    private final String userDirProperty = System.getProperty("user.dir");


    Chapter2Page ch2p;


    @BeforeTest
    public void setup () {


        super.beforeMethod();
        ch2p = new Chapter2Page(this.driver);
        ch2p.navigate();
    }

    @AfterTest
    public void teardown() {

        super.afterMethod();

    }



    //Elements are displayed

    @Test(description = "Buttons", priority = 5, groups = {"display_elements"})
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
