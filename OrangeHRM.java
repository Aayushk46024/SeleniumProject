import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;


public class OrangeHRM {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement username=driver.findElement(By.id("txtUsername"));
        WebElement password=driver.findElement(By.id("txtPassword"));
        WebElement login=driver.findElement(By.name("Submit"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        login.click();
        String actualUrl="https://opensource-demo.orangehrmlive.com/";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        Thread.sleep(2000);
        driver.close();
    }
}