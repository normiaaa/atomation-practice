package Pages;

import NormiaTest.Utility;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Chapter2Page extends Page{

    public Utility utils = new Utility();
    SoftAssertions softAssertions = new SoftAssertions();

    By firstButtonByName = By.name("but2");
    By randomButtonByCss = By.cssSelector("[value='Random']");
    By idButtonById = By.id("but1");
    By siblingButtonByCss = By.cssSelector("[value='Sibling Button']");
    By verifyButtonByName = By.name("verifybutton");
    By chocolateButtonByName = By.name("verifybutton1");



    public Chapter2Page (WebDriver driver) {

        super(driver);

        //Test number 1

        //1st button

    }

    public void clickOnButtonWithName() {

        driver.findElement(firstButtonByName).click();

    }

    public void checkButtonWithNameText() {

        Assert.assertTrue(driver.findElement(firstButtonByName).getAttribute("value").contains(utils.BUTTON_WITH_NAME));

    }

    //2nd button

    public void clickOnRandomButton() {

        driver.findElement(randomButtonByCss).click();

    }

    public void checkRandomButtonText() {

        Assert.assertTrue(driver.findElement(randomButtonByCss).getAttribute("value").contains(utils.BUTTON_RANDOM));
    }

    //3rd button

    public void clickOnButtonWithID() {

        driver.findElement(idButtonById ).click();

    }

    public void checknButtonWithIDText() {

        Assert.assertTrue(driver.findElement(idButtonById ).getAttribute("value").contains(utils.BUTTON_ID));


    }

    //4th button

    public void clickOnSiblingButton() {

        driver.findElement(siblingButtonByCss).click();
    }

    public void checkSiblingButtonText() {

        Assert.assertTrue(driver.findElement(siblingButtonByCss).getAttribute("value").contains(utils.BUTTON_SIBLING));

    }

    //5th button

    public void clickOnVerifyButton() {

        driver.findElement(verifyButtonByName).click();

    }

    public void checkVerifyButtonText() {

        Assert.assertTrue(driver.findElement(verifyButtonByName).getAttribute("value").contains(utils.BUTTON_VERIFY));
    }

    //6th button


    public void clickOnChocolateButton() {

        driver.findElement(chocolateButtonByName).click();


    }

    public void checkChocolateButtonText() {

        Assert.assertTrue(driver.findElement(chocolateButtonByName).getAttribute("value").contains(utils.BUTTON_CHOCOLATE));

    }


}
