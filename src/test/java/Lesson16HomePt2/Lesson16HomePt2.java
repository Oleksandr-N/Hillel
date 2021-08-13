package Lesson16HomePt2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        public void browserClose() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.manage().window().maximize();

            driver.get("https://demoqa.com/browser-windows");
            String originalWindow = driver.getWindowHandle();
            driver.findElement(By.id("windowButton")).click();

            for (String windowHandle : driver.getWindowHandles()) {
                if(!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            driver.close();

            driver.switchTo().window(originalWindow);
            driver.close();
            //driver.quit();

        }

        @Test
        public void browserNavigation() {
//            1. Launch new Browser
//            2. Open DemoQA.com website
//            3. Click on Forms button
//            4. Come back to Home page (Use ‘Back’ command)
//            5. Again go back to Forms page (This time use ‘Forward’ command)
//            6. Again come back to Home page (This time use ‘To’ command)
//            7. Refresh the Browser (Use ‘Refresh’ command)
//            8. Close the Browser

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.manage().window().maximize();

            String homePage = "https://demoqa.com";

            driver.get(homePage);
            WebElement forms = driver.findElement(By.xpath("//h5[normalize-space()='Forms']"));
            forms.click();
            driver.navigate().back();
            driver.navigate().forward();
            driver.navigate().to(homePage);
            driver.navigate().refresh();
            driver.quit();

        }

        @Test
        public void progressBar() {
//            1. Launch new Browser
//            2. Open https://demoqa.com/progress-bar
//            3. Click Start
//            4. Add WebDriverWait for waiting “Reset” button is displayed
//            5. Click reset
//            6. Add WebDriverWait for waiting “Start” button is displayed

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();


            String startButton = "//button[normalize-space()='Start']";

            driver.get("https://demoqa.com/progress-bar");
            driver.findElement(By.xpath(startButton)).click();
            String resetButton = "//button[normalize-space()='Reset']";
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(resetButton)));
            driver.findElement(By.xpath(resetButton)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(startButton)));
        }

        @Test
    public void dynamicProperties() {

//            1. Launch new Browser
//            2. Open “https://demoqa.com/dynamic-properties"
//            3. Add WebDriverWait for waiting to button “Visible After 5 Seconds” to be displayed


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));


        }

}
