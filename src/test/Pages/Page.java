package Pages;

import NormiaTest.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class Page {
    public Utility utils = new Utility();


    WebDriver driver;




    public Page(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void checkTitle () {
        this.driver.get(utils.URL_CHAPTER1);
        Assert.assertTrue(this.driver.getTitle().contains(utils.TITLE));
    }

    public void navigateToURL(String URL) {


        driver.get(URL);

    }

    abstract void navigate();

    public boolean wait(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOf(element));

        return element.isDisplayed();


    }

    public boolean wait(WebElement element, int waitTime) {

        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));

        return element.isDisplayed();

    }





}
