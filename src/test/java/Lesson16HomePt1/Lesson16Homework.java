package Lesson16HomePt1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lesson16Homework {
//        1. Open‌‌“https://demoqa.com/login”‌
//        2. Login‌‌(create ‌‌your ‌‌own ‌‌user ‌‌before)
//        3. Go ‌‌to ‌‌Book‌‌Store
//        4. Choose it‌‌Pocket‌‌Guide
//        5. Click ‌‌“Add ‌‌to ‌‌your ‌‌Collection”‌
//        6. Handle alert ‌‌similar as ‌‌from last ‌‌lesson‌‌(Tap ‌‌Ok)
//        7. Click Back To ‌‌Store
//        8. Click "You‌‌Don’t‌‌Know‌‌JS”‌
//        9. “Add to your ‌‌Collection”‌
//        10. Handle Alert
//        11. Go‌‌to ‌“Profile”‌
//        12. Click "Delete‌‌All‌‌Books"

    @Test
    public void demoQATest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://demoqa.com/login");
        WebElement userLoginField = driver.findElement(By.xpath("//input[@id='userName']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        userLoginField.sendKeys("JD");
        userPasswordField.sendKeys("!@Qqq111");
        loginButton.click();
        Thread.sleep(1000);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement bookStore = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']"));
        javascriptExecutor.executeScript("arguments[0].click();", bookStore);

        WebElement GitPocketGuide = driver.findElement(By.xpath("//a[normalize-space()='Git Pocket Guide']"));
        GitPocketGuide.click();

        WebElement addToYourCollectionButton = driver.findElement(By.xpath("//button[normalize-space()='Add To Your Collection']"));
        javascriptExecutor.executeScript("arguments[0].click();", addToYourCollectionButton);

        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement profile = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"));
        javascriptExecutor.executeScript("arguments[0].click();", profile);

        WebElement deleteAllBooksButton = driver.findElement(By.xpath("//div[@class='text-right button di']//button[@id='submit']"));
        javascriptExecutor.executeScript("arguments[0].click();", deleteAllBooksButton);

        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Thread.sleep(1000);

        alert.accept();
        //Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void saucedemoTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://saucedemo.com");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement firstItem = driver.findElement(By.xpath("//div[1][contains(@class,'inventory_item')]//button[normalize-space()='Add to cart']"));
        firstItem.click();
        WebElement secondItem = driver.findElement(By.xpath("//div[2][contains(@class,'inventory_item')]//button[normalize-space()='Add to cart']"));
        secondItem.click();
        WebElement thirdItem = driver.findElement(By.xpath("//div[3][contains(@class,'inventory_item')]//button[normalize-space()='Add to cart']"));
        thirdItem.click();
        WebElement fourthItem = driver.findElement(By.xpath("//div[4][contains(@class,'inventory_item')]//button[normalize-space()='Add to cart']"));
        fourthItem.click();
        WebElement shoppingCartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCartButton.click();
        WebElement checkoutButton = driver.findElement(By.xpath("//button[normalize-space()='Checkout']"));
        checkoutButton.click();

        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstNameField.sendKeys("Jamie");
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastNameField.sendKeys("Oliver");
        WebElement postalCodeField = driver.findElement(By.xpath("//input[@id='postal-code']"));
        postalCodeField.sendKeys("90210");
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();

        WebElement finishButton = driver.findElement(By.xpath("//button[normalize-space()='Finish']"));
        finishButton.click();

        WebElement homeButton = driver.findElement(By.xpath("//button[normalize-space()='Back Home']"));
        homeButton.click();

        //Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void webdriveruniversityTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        WebElement addNewTodo = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
        addNewTodo.sendKeys("MAKE HOMEWORK");
        addNewTodo.sendKeys("Practice Automation");
        WebElement practiceMagicField = driver.findElement(By.xpath("//li[normalize-space()='Practice magic']"));
        practiceMagicField.click();

        WebElement buyNewRobes = driver.findElement(By.xpath("//li[normalize-space()='Buy new robes']"));
        Actions action = new Actions(driver);
        action.moveToElement(buyNewRobes).build().perform();
        WebElement trashButton = driver.findElement(By.xpath("//li[normalize-space()='Buy new robes']//i[@class='fa fa-trash']"));
        trashButton.click();

        driver.quit();
    }

    @Test
    public void amazonTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        WebElement todaysDeals = driver.findElement(By.xpath("//a[normalize-space()=\"Today's Deals\"]"));
        todaysDeals.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//span[contains(@class,'a-button-inner')]/button[normalize-space()='Add to Cart']"));
        addToCartButton.click();
        Thread.sleep(1000);

        WebElement cartButton = driver.findElement(By.xpath("//a[@id='nav-cart']"));
        cartButton.click();
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
        proceedToCheckoutButton.click();

        driver.quit();

    }
}
