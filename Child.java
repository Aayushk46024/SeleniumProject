import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

class Parent {

    WebDriver driver = new ChromeDriver();
    String names[] = {"Aayush", "Sachin", "Shiphali", "Amanjeet", "Gulshan", "Purvaa", "Gunshajam"};
    String userName =  names[new Random().nextInt(names.length)];

    void login() {

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();

        String actualUrl="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    void addUser() throws InterruptedException {

        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("btnAdd")).click();


        Select dropdown = new Select(driver.findElement(By.name("systemUser[userType]")));
        dropdown.selectByVisibleText("Admin");
        Thread.sleep(1000);
        driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys("Admin A");
        Thread.sleep(1000);
        //String uuid = UUID.randomUUID().toString();

        driver.findElement(By.name("systemUser[userName]")).sendKeys(userName);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.elementToBeClickable(By.name("systemUser[userName]")));
        Thread.sleep(1000);
        Select dropdown1 = new Select(driver.findElement(By.name("systemUser[status]")));
        dropdown1.selectByVisibleText("Enabled");
        Thread.sleep(1000);
        driver.findElement(By.name("systemUser[password]")).sendKeys("#qazx3598!");
        Thread.sleep(1000);
        driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys("#qazx3598!");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.id("btnSave")).click();

//        boolean msg = driver.getPageSource().contains("Successfully Saved");
//        Assert.assertTrue(msg);
//        System.out.println(msg);
//        WebElement ele = driver.findElement(By.xpath("//div[@class='modal hide']//div[contains(text(),'Successfully Saved'))]"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//        wait.until(ExpectedConditions.visibilityOf(ele));
//        Assert.assertTrue(ele.isDisplayed(), "Success Message is Not Displayed");

    }

    void search() {

        driver.findElement(By.id("menu_admin_viewAdminModule")).click();

        //String uuid = UUID.randomUUID().toString();
        WebElement search = driver.findElement(By.id("searchSystemUser_userName"));
        search.sendKeys(userName);
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

    void edit() throws InterruptedException {
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();

        driver.findElement(By.partialLinkText("Aaliyah.Haq")).click();

        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(1000);

        Select dropdown = new Select(driver.findElement(By.name("systemUser[userType]")));
        dropdown.selectByVisibleText("Admin");
        Thread.sleep(1000);
        driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys("Admin A");
        Thread.sleep(1000);

        driver.findElement(By.name("systemUser[userName]")).sendKeys(userName);
        Thread.sleep(1000);
        Select dropdown1 = new Select(driver.findElement(By.name("systemUser[status]")));
        dropdown1.selectByVisibleText("Enabled");
        Thread.sleep(1000);

        driver.findElement(By.id("btnSave")).click();

    }

    void recruitment() throws InterruptedException {
        WebElement recruitment = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
        recruitment.click();

        WebElement fromDate = driver.findElement(By.id("candidateSearch_fromDate"));
        fromDate.clear();
        fromDate.sendKeys("2021-01-01");

        WebElement toDate = driver.findElement(By.id("candidateSearch_toDate"));
        toDate.clear();
        toDate.sendKeys("2021-01-10");

        driver.findElement(By.id("btnSrch")).click();


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
        //c1.addUser();
        //c1.search();
        c1.edit();
        //c1.recruitment();
//        c1.delete();
//        c1.logout();

    }
}