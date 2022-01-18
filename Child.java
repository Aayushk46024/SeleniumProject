import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

class Parent {

    WebDriver driver = new ChromeDriver();

    void login() {

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
    }

    void addUser() {

        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("btnAdd")).click();


        Select dropdown = new Select(driver.findElement(By.name("systemUser[userType]")));
        dropdown.selectByVisibleText("Admin");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys("Admin A");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("systemUser[userName]")).sendKeys("Aayushkhand");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select dropdown1 = new Select(driver.findElement(By.name("systemUser[status]")));
        dropdown1.selectByVisibleText("Enabled");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("systemUser[password]")).sendKeys("#Pur102030");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys("#Pur102030");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.name("btnSave")).click();
    }

    void search() {

        driver.findElement(By.id("menu_admin_viewAdminModule")).click();

        WebElement search = driver.findElement(By.id("searchSystemUser_userName"));
        search.sendKeys("Aayushkhand");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.findElement(By.id("searchBtn")).click();
    }

    void delete() throws InterruptedException {

        WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        admin.click();

        driver.findElement(By.id("ohrmList_chkSelectRecord_10")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("btnDelete")).click();

        driver.findElement(By.id("dialogDeleteBtn")).click();

        /*
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        Thread.sleep(2000);
        alert1.accept();

        if(driver.getPageSource().contains("Successfully Deleted"))
            System.out.println("Successfully Deleted");
        System.out.println("*********************");
        */

        driver.findElement(By.id("ohrmList_chkSelectAll")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btnDelete")).click();

        driver.findElement(By.id("dialogDeleteBtn")).click();

        /*
        Alert alertAll = driver.switchTo().alert();
        String text = alertAll.getText();
        alertAll.accept();

        if(driver.getPageSource().contains("Successfully Deleted"))
            System.out.println("Successfully Deleted");
        System.out.println("*********************");
         */

    }

    void logout() {

        driver.findElement(By.id("welcome")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        logout.click();

        driver.close();

    }

}
public class Child extends Parent {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        Child c1 = new Child();
        c1.login();
        c1.addUser();
        c1.search();
        c1.delete();
        c1.logout();

    }
}