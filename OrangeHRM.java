import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import javax.jws.soap.SOAPBinding;
import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static org.openqa.selenium.Keys.*;


public class OrangeHRM {
    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
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
        Assert.assertEquals(actualUrl, expectedUrl);



        WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        admin.click();

        WebElement add  = driver.findElement(By.id("btnAdd"));
        add.click();


        Select dropdown = new Select(driver.findElement(By.name("systemUser[userType]")));
        dropdown.selectByVisibleText("Admin");
        Thread.sleep(1000);
        WebElement employeeName = driver.findElement(By.name("systemUser[employeeName][empName]"));
        employeeName.sendKeys("Admin A");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.name("systemUser[userName]"));
        userName.sendKeys("Aayushk");
        Thread.sleep(1000);
        Select dropdown1 = new Select(driver.findElement(By.name("systemUser[status]")));
        dropdown1.selectByVisibleText("Enabled");
        Thread.sleep(1000);
        WebElement Password = driver.findElement(By.name("systemUser[password]"));
        Password.sendKeys("#Pur102030");
        Thread.sleep(1000);
        WebElement confirmPassword = driver.findElement(By.name("systemUser[confirmPassword]"));
        confirmPassword.sendKeys("#Pur102030");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,350)", "");

        WebElement save = driver.findElement(By.name("btnSave"));
        save.click();
        //System.out.println("Hello");


//        WebElement msg = driver.findElement(By.id("successBodyEdit"));
//        System.out.println(msg);

        WebElement search = driver.findElement(By.id("searchSystemUser_userName"));
        search.sendKeys("Aayushk");
        Thread.sleep(1000);

        WebElement btn = driver.findElement(By.id("searchBtn"));
        btn.click();

        Thread.sleep(2000);
        //driver.close();
    }
}