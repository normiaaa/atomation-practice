package Pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Chapter1Page extends Page{


    @FindBy(css = ".ajaxdiv.wind")
    private
    WebElement ajaxDiv;

    @FindBy(className = "multiplewindow")
    private
    WebElement multipleWindowButton1;

    @FindBy(className = "multiplewindow2")
    private
    WebElement multipleWindowButton2;


    @FindBy(className = "loadajax")
    private
    WebElement elementAjax;

    @FindBy(id = "secondajaxbutton")
    private
    WebElement secondAjaxButton;

    @FindBy(id = "radiobutton")
    private
    WebElement radioButton;

    @FindBy(id = "selecttype")
    private
    WebElement selectElement;

    @FindBy(id = "verifybutton")
    private
    WebElement verifyButton;

    @FindBy(id = "divontheleft")
    private
    WebElement leftDiv;


    //Right click on web element -> Refactor -> Encapsulate Fields



    SoftAssertions softAssertions = new SoftAssertions();
    //Assert.assert equals














    public Chapter1Page (WebDriver driver) {

        super(driver);

    }

    //Test number 1

    public void checkIfButtonIsDisplayed() {

        verifyButton.isDisplayed();
        Assert.assertTrue(leftDiv.getText().contains(utils.ASSERT_TEXT_PAGE));

    }


    //Test number 2

    public void clickOnRadioButton() {
        radioButton.click();
    }

    public void selectItemsFromDropdown() {
        selectElement.click();

        Select select = new Select(selectElement);
        select.selectByValue(utils.SELECT_SELENIUM_VALUE1);
        select.selectByValue(utils.SELECT_SELENIUM_VALUE2);
        select.selectByValue(utils.SELECT_SELENIUM_VALUE3);
        select.selectByValue(utils.SELECT_SELENIUM_VALUE4);

        selectElement.click();

    }

    public void selectSpecificItemFromDropdown(String itemToSelect) {

        selectElement.click();
        Select select = new Select(selectElement);
        select.selectByValue(itemToSelect);

    }



    // Test number 3

    public void clickOnNewWindow1() {


        //First Window click

        multipleWindowButton1.click();


    }

    //First Window check

    public void checkNewWindow1() {

        softAssertions.assertThat(multipleWindowButton1.getAttribute("href")).isEqualTo(utils.WINDOW_URL);
    }

    public void openNewWindow2() {

        //Second Window open

        multipleWindowButton2.click();
        System.out.println(multipleWindowButton2.getAttribute("href"));
       // softAssertions.assertThat(driver.findElement(multipleWindowButtonByClass2).getAttribute("href").equals(utils.WINDOW_URL));

    }

    public void checkNewWindow2() {

        //Second Window check

        softAssertions.assertThat(multipleWindowButton2.getAttribute("href")).isEqualTo(utils.WINDOW_URL);
    }

    public void clickFirstAjaxElement() {

        //Load a page with Ajax

       elementAjax.click();

    }

    public void checkFirstAjaxElement() {

        //Load a page with Ajax

        elementAjax.click();
        Assert.assertTrue(ajaxDiv.getText().contains(utils.AJAX_ELEMENT));
    }

    // Test number 4

    public void clickSecondAjaxElement() {

        secondAjaxButton.click();
        softAssertions.assertThat(secondAjaxButton.getAttribute("href")).contains(utils.SECOND_AJAX_BUTTON);


    }

    public void checkSecondAjaxElement() {

        secondAjaxButton.click();
        softAssertions.assertThat(secondAjaxButton.getAttribute("href")).contains(utils.SECOND_AJAX_BUTTON);


    }


    public WebElement getAjaxDiv() {
        return ajaxDiv;
    }
}
