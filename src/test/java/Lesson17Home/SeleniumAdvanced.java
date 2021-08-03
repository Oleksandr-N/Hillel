package Lesson17Home;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumAdvanced {

    @Test
    public void taskA() {
//  1. Open https://demoqa.com/frames
//  2. Switch to first frame
//  3. Get text from frame and print it
//  4. Switch to default content
//  5. Switch to second frame
//  6. Get text from second frame and print it

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String targetURL = "https://demoqa.com/frames";
        driver.get(targetURL);
        //WebElement frame = driver.findElement(By.id("frame2"));
        driver.switchTo().frame("frame2");
        String frameText = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(frameText);

    }

    @Test
    public void taskB() {
//  1.Open https://demoqa.com/automation-practice-form
//  2. Fill the form (please skip steps upload file and subjects)
//  3. Submit
//

    }

    @Test
    public void taskC() {
//  1. Open https://demoqa.com/text-box
//  2. Fill text form
//  3. Submit


    }

    @Test
    public void taskD() {
//  1. Open http://way2automation.com/way2auto_jquery/dropdown.php#load_box
//  2. Choose Austria using text (Pay Attention that dropdown placed in iframe)
//  3. Choose 25th country
//  4. Choose country by value “SriLanka”

    }

}
