package NormiaTest;

import Pages.Chapter3Page;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;



public class Chapter3 {



    public Utility utils = new Utility();
    private final String userDirProperty = System.getProperty("user.dir");
    private ChromeDriver chromeDriver;

    Chapter3Page ch3p;


    //TODO : when all the words from myText are found in the list, break the iteration.

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
        chromeDriver.get(utils.URL_CHAPTER3);
    }

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get(utils.URL_CHAPTER3);
        ch3p = new Chapter3Page(this.chromeDriver);
    }

    @AfterTest
    public void tearDown() {
        chromeDriver.quit();
    }




    //Elements are displayed

    @Test(description = "Buttons", priority = 1)
    public void contentTest() throws InterruptedException {
       // chromeDriver.get("http://book.theautomatedtester.co.uk/chapter3");

        //Random Changing element

        ch3p.refresh();
        ch3p.word();



        //Check zodiac text

        ch3p.checkZodiacElements();

        //Check current date










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




    }
}
