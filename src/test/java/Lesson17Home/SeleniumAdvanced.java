package Lesson17Home;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        driver.switchTo().frame("frame1");
        String frame1Text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(frame1Text);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        String frame2Text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(frame2Text);

        driver.quit();
    }

    @Test
    public void taskB() {
//  1.Open https://demoqa.com/automation-practice-form
//  2. Fill the form (please skip steps upload file and subjects)
//  3. Submit
//
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstNameTextField = driver.findElement(By.id("firstName"));
        firstNameTextField.sendKeys("John");

        WebElement lastNameTextField = driver.findElement(By.id("lastName"));
        lastNameTextField.sendKeys("Doe");

        WebElement emailTextField = driver.findElement(By.id("userEmail"));
        emailTextField.sendKeys("johnny_d@google.com");

        WebElement genderRadioButton = driver.findElement(By.id("gender-radio-1"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", genderRadioButton);
        //genderRadioButton.click();

        WebElement mobileTextField  = driver.findElement(By.id("userNumber"));
        WebElement dateOfBirthTextField = driver.findElement(By.id("dateOfBirthInput"));
        WebElement hobbiesCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Music']"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        //css-2b097c-container
        WebElement stateAndCityDropdown = driver.findElement(By.xpath("//*[contains(text(),'NCR')]"));
        WebElement city = driver.findElement(By.xpath("Gurgaon"));
        WebElement selectCityDropdown = driver.findElement(By.id(""));
        WebElement submitButton = driver.findElement(By.id("submit"));

    }

    @Test
    public void taskC() {
//  1. Open https://demoqa.com/text-box
//  2. Fill text form
//  3. Submit

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        WebElement submit = driver.findElement(By.id("submit"));

        fullName.sendKeys("John Doe");
        email.sendKeys("johndoe@google.com");
        currentAddress.sendKeys("New York, New York");
        permanentAddress.sendKeys("Los Angeles, California");
        submit.click();

        driver.quit();
    }

    @Test
    public void taskD() {
//  1. Open http://way2automation.com/way2auto_jquery/dropdown.php#load_box
//  2. Choose Austria using text (Pay Attention that dropdown placed in iframe)
//  3. Choose 25th country
//  4. Choose country by value “SriLanka”

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://way2automation.com/way2auto_jquery/dropdown.php#load_box");
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Frames on this page: " + size);

        driver.switchTo().frame(0);
        WebElement select = driver.findElement(By.tagName("select"));
        Select selectOption = new Select(select);
        selectOption.selectByVisibleText("Austria");
        selectOption.selectByIndex(24);
        selectOption.selectByValue("SriLanka");

        driver.quit();
    }

}
