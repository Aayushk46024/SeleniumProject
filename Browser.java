import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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


//        driver.switchTo().newWindow(WindowType.WINDOW);
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.switchTo().window(originalWindow);
//        driver.navigate().to("https://www.geeksforgeeks.org/operators-in-java/");
//        driver.switchTo().frame("packageFrame");
//        driver.findElement(By.linkText("Arithmetic Operators")).click();
//        driver.switchTo().defaultContent();

        driver.manage().window().getSize().getWidth();
        driver.manage().window().getSize().getHeight();

        Dimension size = driver.manage().window().getSize();
        System.out.println(size.getWidth());
        System.out.println(size.getHeight());

        driver.manage().window().setSize(new Dimension(800,600));

        Thread.sleep(2000);
        driver.close();
        //driver.quit();

    }
}
