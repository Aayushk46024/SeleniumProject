import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //js alert
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        Thread.sleep(2000);
        alert1.accept();

        if(driver.getPageSource().contains("You successfully clicked an alert"))
            System.out.println("You successfully clicked an alert");
        System.out.println("*********************");

        //js confirm
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        Thread.sleep(2000);
        alert2.dismiss();


        if(driver.getPageSource().contains("You clicked: Cancel"))
            System.out.println("You clicked: Cancel");
        System.out.println("*********************");

        //prompt
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys("Automation step by step");
        Thread.sleep(2000);
        alert3.accept();


        if(driver.getPageSource().contains("You entered: Automation step by step"))
            System.out.println("You entered: Automation step by step");
        System.out.println("*********************");


        driver.close();
    }
}
