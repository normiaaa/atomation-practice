package Pages;

import NormiaTest.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Page {
    public Utility utils = new Utility();


    WebDriver driver;




    public Page(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void checkTitle() {
        this.driver.get(utils.URL_CHAPTER1);
        Assert.assertTrue(this.driver.getTitle().contains(utils.TITLE));
    }

    public void navigateToURL(String URL) {


        driver.get(URL);

    }





}
