import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ProxyDemo {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//        WebDriver driver=new ChromeDriver();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//
//        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Proxy proxy = new Proxy();
        proxy.setAutodetect(false);
        proxy.setHttpProxy("localhost:8080");
        proxy.setSslProxy("localhost:8080");


    }
}
