package Pages;

import NormiaTest.Utility;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Chapter2Page extends Page{

    public Utility utils = new Utility();
    SoftAssertions softAssertions = new SoftAssertions();

    @FindBy(name = "but2")
    private
    WebElement firstButton;

    @FindBy(css = "[value='Random']")
    private
    WebElement randomButton;

    @FindBy(id = "but1")
    private
    WebElement idButton;

    @FindBy(css = "[value='Sibling Button']")
    private
    WebElement siblingButton;

    @FindBy(name = "verifybutton")
    private
    WebElement verifyButton;

    @FindBy(name = "verifybutton1")
    private
    WebElement chocolateButton;

    @Override
    public void checkTitle() {
        this.driver.get(utils.URL_CHAPTER2);
    }


    public void navigate() {
        driver.get(utils.URL_CHAPTER2);

    }


    public Chapter2Page (WebDriver driver) {

        super(driver);

        //Test number 1

        //1st button

    }

    public void clickOnButtonWithName() {

        firstButton.click();

    }

    public void checkButtonWithNameText() {

        Assert.assertTrue(firstButton.getAttribute("value").contains(utils.BUTTON_WITH_NAME));

    }

    //2nd button

    public void clickOnRandomButton() {

        randomButton.click();

    }

    public void checkRandomButtonText() {

        Assert.assertTrue(randomButton.getAttribute("value").contains(utils.BUTTON_RANDOM));
    }

    //3rd button

    public void clickOnButtonWithID() {

        idButton.click();

    }

    public void checknButtonWithIDText() {

        Assert.assertTrue(idButton.getAttribute("value").contains(utils.BUTTON_ID));


    }

    //4th button

    public void clickOnSiblingButton() {

        siblingButton.click();
    }

    public void checkSiblingButtonText() {

        siblingButton.getAttribute("value").contains(utils.BUTTON_SIBLING);

    }

    //5th button

    public void clickOnVerifyButton() {

        verifyButton.click();

    }

    public void checkVerifyButtonText() {

        Assert.assertTrue(verifyButton.getAttribute("value").contains(utils.BUTTON_VERIFY));
    }

    //6th button


    public void clickOnChocolateButton() {

        chocolateButton.click();


    }

    public void checkChocolateButtonText() {

        Assert.assertTrue(chocolateButton.getAttribute("value").contains(utils.BUTTON_CHOCOLATE));

    }


}
