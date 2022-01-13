import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Browser {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        String originalWindow = driver.getWindowHandle();
//        driver.navigate().to("http://automationstepbystep.com");
//
//        driver.navigate().back();
//        Thread.sleep(2000);
//        driver.navigate().forward();
//        Thread.sleep(2000);
//        driver.navigate().refresh();


        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(originalWindow);

        Thread.sleep(2000);
        driver.close();
        //driver.quit();

    }
}
