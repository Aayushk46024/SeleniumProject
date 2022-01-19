import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageLoadingDemo {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver(options);

        driver.get("https://google.com");

        driver.close();
        driver.quit();
    }
}
