package Lesson16HomePt2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lesson16HomePt2 {

    @Test
        public  void shopDemoQA() {
//        1.  Launch a new Chrome browser.
//        2.  Open Shop.DemoQA.com
//        3.  Get Page Title name and Title length
//        4.  Print PageTitle and Title length in console(sout).
//        5.  Get PageURL and verify if it is a correct page opened
//        6.  Get Page Source (HTMLSourcecode) and Page Source length
//        7.  Print PageLength.
//        8.  Close the Browser.


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String targetURL = "http://shop.demoqa.com/";

        driver.get(targetURL);
        String pageTitle = driver.getTitle();
        int titleLength = pageTitle.length();
        System.out.println("Web page title: " + pageTitle +", title length: " + titleLength);

        String currentPageURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentPageURL);

//        System.out.println(targetURL.replace("http://", ""));
//        System.out.println(currentPageURL.replace("http://", ""));

        if (targetURL.replace("http://", "").equals
                (currentPageURL.replace("http://", ""))) {
            System.out.println(">>> Target URL corresponds to current URL");
            } else System.out.println(">>> Target URL does not correspond to current URL");

        String pageLength = driver.getPageSource();
        System.out.println("Page source length is: " + pageLength.length());

        driver.quit();
        }

        @Test
        public void toolsQATest() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.manage().window().maximize();



        }

}
