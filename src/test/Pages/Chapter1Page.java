package Pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Chapter1Page extends Page{


    @FindBy(css = ".ajaxdiv.wind")
    private
    WebElement ajaxDiv;

    //Right click on web element -> Refactor -> Encapsulate Fields



    SoftAssertions softAssertions = new SoftAssertions();
    //Assert.assert equals
    By multipleWindowButtonByClass1 = By.className("multiplewindow");
    By multipleWindowButtonByClass2 = By.className("multiplewindow2");
    By elementAjaxClass = By.className("loadajax");
    By secondAjaxButton = By.id("secondajaxbutton");
    By radioButtonElementId = By.id("radiobutton");
    By selectElementId = By.id("selecttype");
    By verifyButton = By.id("verifybutton");
    By leftDiv = By.id("divontheleft");






    public Chapter1Page (WebDriver driver) {

        super(driver);

    }

    //Test number 1

    public void checkIfButtonIsDisplayed() {

        driver.findElement(verifyButton).isDisplayed();
        Assert.assertTrue(driver.findElement(leftDiv).getText().contains(utils.ASSERT_TEXT_PAGE));

    }


    //Test number 2

    public void clickOnRadioButton() {
        driver.findElement(radioButtonElementId).click();
    }

    public void selectItemsFromDropdown() {
        driver.findElement(selectElementId).click();

        Select select = new Select(driver.findElement(selectElementId));
        select.selectByValue(utils.SELECT_SELENIUM_VALUE1);
        select.selectByValue(utils.SELECT_SELENIUM_VALUE2);
        select.selectByValue(utils.SELECT_SELENIUM_VALUE3);
        select.selectByValue(utils.SELECT_SELENIUM_VALUE4);

        driver.findElement(selectElementId).click();

    }

    public void selectSpecificItemFromDropdown(String itemToSelect) {

        driver.findElement(selectElementId).click();
        Select select = new Select(driver.findElement(selectElementId));
        select.selectByValue(itemToSelect);

    }



    // Test number 3

    public void clickOnNewWindow1() {


        //First Window click

        driver.findElement(multipleWindowButtonByClass1).click();


    }

    //First Window check

    public void checkNewWindow1() {

        softAssertions.assertThat(driver.findElement(multipleWindowButtonByClass1).getAttribute("href")).isEqualTo(utils.WINDOW_URL);
    }

    public void openNewWindow2() {

        //Second Window open

        driver.findElement(multipleWindowButtonByClass2).click();
        System.out.println(driver.findElement(multipleWindowButtonByClass2).getAttribute("href"));
       // softAssertions.assertThat(driver.findElement(multipleWindowButtonByClass2).getAttribute("href").equals(utils.WINDOW_URL));

    }

    public void checkNewWindow2() {

        //Second Window check

        softAssertions.assertThat(driver.findElement(multipleWindowButtonByClass2).getAttribute("href")).isEqualTo(utils.WINDOW_URL);
    }

    public void clickFirstAjaxElement() {

        //Load a page with Ajax

        driver.findElement(elementAjaxClass).click();

    }

    public void checkFirstAjaxElement() {

        //Load a page with Ajax

        driver.findElement(elementAjaxClass).click();
        Assert.assertTrue(ajaxDiv.getText().contains(utils.AJAX_ELEMENT));
    }

    // Test number 4

    public void clickSecondAjaxElement() {

        driver.findElement(secondAjaxButton).click();
        softAssertions.assertThat(driver.findElement(secondAjaxButton).getAttribute("href")).contains(utils.SECOND_AJAX_BUTTON);


    }

    public void checkSecondAjaxElement() {

        driver.findElement(secondAjaxButton).click();
        softAssertions.assertThat(driver.findElement(secondAjaxButton).getAttribute("href")).contains(utils.SECOND_AJAX_BUTTON);


    }


    public WebElement getAjaxDiv() {
        return ajaxDiv;
    }
}
