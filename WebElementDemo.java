import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class WebElementDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        /*
        //find element
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium" + Keys.ENTER);
//        Thread.sleep(1000);
//
//        driver.findElement(By.name("btnK")).click();


        //find elements
        driver.get("https://trytestingthis.netlify.app/");
        List<WebElement> elements = driver.findElements( By.tagName("select"));

        for (WebElement element : elements){
            System.out.println(element.getText());
        }


        // active element
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("selenium");

        String title = driver.switchTo().activeElement().getAttribute("title");
        System.out.println(title);



        // check element is enabled, is selected
        driver.get("http://the-internet.herokuapp.com/checkboxes");;
        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='chekcbox'])"));
        //Thread.sleep(1000);
        System.out.println(checkbox.isEnabled());
        System.out.println(checkbox.isSelected());

         */
        driver.get("https://google.com");
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.name("q"));
        actions.keyDown(Keys.SHIFT).sendKeys("selenium").keyUp(Keys.SHIFT).sendKeys(" selenium").perform();
        Thread.sleep(2000);
        searchBox.clear();

        Thread.sleep(1000);
        driver.quit();
    }
}
