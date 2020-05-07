package Pages;

import NormiaTest.Utility;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.*;

public class Chapter3Page extends Page {

    public Utility utils = new Utility();
    SoftAssertions softAssertions = new SoftAssertions();

    @FindBy(id = "leftdiv")
    private
    WebElement leftDiv;

    @FindBy(id = "divinthecenter")
    private
    WebElement zodiacElements;

    @FindBy(id = "centerdiv")
    private
    WebElement currentDate;

    public void navigate() {
        driver.get(utils.URL_CHAPTER3);
    }

    @Override
    public void checkTitle() {
        this.driver.get(utils.URL_CHAPTER3);
    }




    public Chapter3Page (WebDriver driver) {

        super(driver);

    }

    //Test number 1

    //Random Changing Element

        public void refresh () {
            driver.navigate().refresh();

        }

        public String word (int id) {

//            List<String> expectedWords = new ArrayList<>(Arrays.asList("pool", "fool", "mool", "cool"));
//            Integer counter = 0;
//
//            boolean findPool = false;
//            boolean findFool = false;
//            boolean findMool = false;
//            boolean findCool = false;

            String text = "";




//            for (; ; ) {
//                counter++;

                String myText = leftDiv.getText();

                switch (myText) {

                    case "pool":
                        Assert.assertEquals("pool", myText);
                        return myText;

                    case "fool":
                        Assert.assertEquals("fool", myText);
                        return myText;


                    case "mool":
                        Assert.assertEquals("mool", myText);
                        return myText;

                    case "cool":
                        Assert.assertEquals("cool", myText);
                        return myText;

                    default:
                        return myText;


                }



            }

//            System.out.println("Number of final retries is: " + counter);
//        }


        //Check the second text - zodiac elements

        public void checkZodiacElements() {

            zodiacElements.isDisplayed();
            Assert.assertTrue(zodiacElements.getText().equals(utils.TEXT_ZODIAC));

        }

        public void checkCurrentDate() {

            Date now = new Date();
            String str1 = "EEE dd MMM yyyy";

            SimpleDateFormat dateFormat = new SimpleDateFormat(str1, Locale.US);
            Assert.assertTrue(currentDate.getText().equals(dateFormat.format(now)));



        }
}

