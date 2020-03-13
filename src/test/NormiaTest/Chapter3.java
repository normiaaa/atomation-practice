package NormiaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class Chapter3 {


    private Utils utilsFunction = new Utils();
    private final String userDirProperty = System.getProperty("user.dir");
    private ChromeDriver chromeDriver;


    public void refresh () {
        chromeDriver.navigate().refresh();
    }

    public void word () {

        List<String> expectedWords = new ArrayList<>(Arrays.asList("pool", "fool", "mool", "cool")) ;
        Integer counter = 0;

        for(;;) {
            counter++;

            String myText = chromeDriver.findElementById("leftdiv").getText();

            if(expectedWords.contains(myText)) {
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




    //TODO : when all the words from myText are found in the list, break the iteration.



    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter3");
    }

    @AfterTest
    public void tearDown() {
        chromeDriver.quit();
    }

    //Elements are displayed

    @Test(description = "Buttons", priority = 1)
    public void contentTest() throws InterruptedException {
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter3");



        //1st Text

        chromeDriver.findElementById("divinthecenter").click();
        Assert.assertTrue(chromeDriver.findElementById("divinthecenter").getText().equals("Virgo Cancer Capricorn'"));

        //2nd Text






        //TODO :  create a for loop with 15+ iterations and an if condition if you have all 4 elements then break;







//        chromeDriver.findElementById("leftdiv").click();
//        String myText = chromeDriver.findElementById("leftdiv").getText();
//
//        List<String> words = new ArrayList<String>();
//        words.add(chromeDriver.findElementById("leftdiv").getText());
//        System.out.println(">>>>>" + myText + "<<<<<<<");
//        refresh();
//
//        System.out.println(">>>>>" + myText + "<<<<<<<");
//
//        refresh();
//
//        System.out.println(">>>>>" + myText + "<<<<<<<");
//
//        refresh();
//
//        System.out.println(">>>>>" + myText + "<<<<<<<");
//
//        refresh();
//
//        System.out.println(">>>>>" + myText + "<<<<<<<");
//
//       refresh();
//
//        System.out.println(">>>>>" + myText + "<<<<<<<");
//
//        Assert.assertTrue(chromeDriver.findElementById("leftdiv").getText().contains("ool"));
//
//        chromeDriver.findElementById("leftdiv").getText();



        //The text is changing after each refresh in this situation. I decided to test this using the above method -> is there a better way to do this?
        //I saw that there are 4 variations of words, each one containing "ool". I have not found any methods online on how to test text which changes
        //after each refresh?

        //Current date method


        Date now = new Date();
        String str1 = "EEE dd MMM yyyy";

        SimpleDateFormat dateFormat = new SimpleDateFormat(str1, Locale.US);
        Assert.assertTrue(chromeDriver.findElementById("centerdiv").getText().equals(dateFormat.format(now)));


    }
}
