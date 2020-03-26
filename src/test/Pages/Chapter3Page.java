package Pages;

import NormiaTest.Utility;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.*;

public class Chapter3Page extends Page {

    public Utility utils = new Utility();
    SoftAssertions softAssertions = new SoftAssertions();

    By leftDivByID = By.id("leftdiv");
    By zodiacElementsByID = By.id("divinthecenter");
    By currentDateByID = By.id("centerdiv");

    public Chapter3Page (WebDriver driver) {

        super(driver);

    }

    //Test number 1

    //Random Changing Element

        public void refresh () {
            driver.navigate().refresh();

        }

        public void word () {

            List<String> expectedWords = new ArrayList<>(Arrays.asList("pool", "fool", "mool", "cool"));
            Integer counter = 0;

            for (; ; ) {
                counter++;

                String myText = driver.findElement(leftDivByID).getText();

                if (expectedWords.contains(myText)) {
                    Assert.assertTrue(expectedWords.contains(myText));
                    expectedWords.remove(myText);
                    refresh();
                }


                if (expectedWords.size() == 0) {
                    break;
                }
            }


            System.out.println("Number of final retries is: " + counter);
        }

        //Check the second text - zodiac elements

        public void checkZodiacElements() {

            driver.findElement(zodiacElementsByID).isDisplayed();
            Assert.assertTrue(driver.findElement(zodiacElementsByID).getText().equals(utils.TEXT_ZODIAC));

        }

        public void checkCurrentDate() {

            Date now = new Date();
            String str1 = "EEE dd MMM yyyy";

            SimpleDateFormat dateFormat = new SimpleDateFormat(str1, Locale.US);
            Assert.assertTrue(driver.findElement(currentDateByID).getText().equals(dateFormat.format(now)));



        }
}

