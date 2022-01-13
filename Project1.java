import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Project1 {

    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        // Launch Website
        driver.get("https://www.google.com/");

        driver.close();

    }

}  