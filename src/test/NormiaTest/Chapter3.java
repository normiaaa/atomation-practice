package NormiaTest;

import Pages.Chapter3Page;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Chapter3 extends TestClassParent {



    public Utility utils = new Utility();
    private final String userDirProperty = System.getProperty("user.dir");
    private ChromeDriver chromeDriver;

    Chapter3Page ch3p;


    @BeforeTest
    public void setup() {

        super.beforeMethod();
        ch3p = new Chapter3Page(this.driver);
        ch3p.navigate();

    }

    //Test 6: Check if elements are displayed

    @Test(description = "Buttons", priority = 6)
    public void contentTest() throws InterruptedException {

        //Random Changing element

        int counter = 0;
        int id = 0;

        String content = "";

        do  {

            content = ch3p.word(id++);
            ch3p.refresh();

            if (id == 4)
                System.out.println("Number of final retries is: " + counter);

            counter++;


        }

        while (id <= 4);


        //Check zodiac text

        ch3p.checkZodiacElements();

    }

        //Check current date


    }

