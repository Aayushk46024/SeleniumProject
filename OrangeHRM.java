import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.openqa.selenium.support.ui.Select;
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
        String actualUrl="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

       WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
       admin.click();

        WebElement add  = driver.findElement(By.id("btnAdd"));
        add.click();


        Select dropdown = new Select(driver.findElement(By.name("systemUser[userType]")));
        dropdown.selectByVisibleText("Admin");
        WebElement employeeName = driver.findElement(By.name("systemUser[employeeName][empName]"));
        employeeName.sendKeys("Admin A");
        WebElement userName = driver.findElement(By.name("systemUser[userName]"));
        userName.sendKeys("Akshay");
        Select dropdown1 = new Select(driver.findElement(By.name("systemUser[status]")));
        dropdown1.selectByVisibleText("Enabled");
        WebElement Password = driver.findElement(By.name("systemUser[password]"));
        Password.sendKeys("@Aayush456648");
        WebElement confirmPassword = driver.findElement(By.name("systemUser[confirmPassword]"));
        confirmPassword.sendKeys("@Aayush456648");

        WebElement s1 = driver.findElement(By.name("btnSave"));
        s1.click();

        Thread.sleep(2000);
        //driver.close();
    }
}