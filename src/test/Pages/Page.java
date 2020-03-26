package Pages;

import NormiaTest.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Page {
    public Utility utils = new Utility();


    WebDriver driver;




    public Page(WebDriver driver){

        this.driver = driver;

    }
    public void checkTitle() {
        this.driver.get(utils.URL_CHAPTER1);
        Assert.assertTrue(this.driver.getTitle().contains(utils.TITLE));
    }



}
