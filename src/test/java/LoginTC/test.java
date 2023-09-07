package LoginTC;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class test {
    public static WebDriver driver;

    public static Properties props;

    public void LoginTest() throws IOException {
            FileReader reader= new FileReader("./src/main/resources/loginLocators.properties");
            props=new Properties();
            System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
            props.load(reader);
            // Instantiate a ChromeDriver class.
            driver = new ChromeDriver();
            driver.manage().window().maximize();
   }

    @Test
    public void ValidLoginTC() throws InterruptedException {
        driver.get("https://akshaycrm.odoo.com/web/login");
        String username = props.getProperty("LOGIN.username.xpath");
        String password = props.getProperty("LOGIN.password.xpath");
        String submitBtn = props.getProperty("LOGIN.submit.xpath");
        driver.findElement(By.xpath(username)).sendKeys("akshaytest345@gmail.com");
        driver.findElement(By.xpath(password)).sendKeys("LenovoFlex2");
        driver.findElement(By.xpath(submitBtn)).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String contactsCTA = props.getProperty("CONTACTS.CTA.xpath");
        driver.findElement(By.xpath(contactsCTA)).click();

        String newContactBtn = props.getProperty("CONTACTS.NEW.Btn.xpath");
        //driver.manage().wait(5000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        driver.findElement(By.xpath("//button[@class='btn btn-secondary o_switch_view o_map fa fa-map-marker']")).click();

        //driver.findElement(By.xpath("//button[@class='btn btn-secondary o_switch_view o_list oi oi-view-list']")).click();

//        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
//        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='o_control_panel_main_buttons d-flex gap-1 d-empty-none d-print-none']//button[1])[2]")));

      //  driver.findElement(By.xpath("(//div[@class='o_control_panel_main_buttons d-flex gap-1 d-empty-none d-print-none']//button[1])[2]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Aksh')]")).click();
        //driver.get("https://akshaycrm.odoo.com/web#cids=1&menu_id=110&action=146&model=res.partner&view_type=form");
        //driver.findElement(By.xpath("//input[@type='radio' and @data-value='person']")).click();
        //driver.findElement(By.xpath("//div[@name='name']/input")).sendKeys("akshay LoginTC.test");
        //driver.findElement(By.xpath("//input[@type='text' and @placeholder='Company Name...']")).sendKeys("ABC corporation");
        //driver.findElement(By.xpath("//input[@type='text' and @placeholder='City']")).sendKeys("Nagpur");
        //driver.findElement(By.xpath("//input[@type='text' and @placeholder = 'State']")).sendKeys("Maharashtra");
        //driver.findElement(By.xpath("//input[@type='text' and @placeholder = 'State']")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//button[@data-tooltip ='Save manually']")).click();

        driver.findElement(By.xpath("//div[class='o-dropdown dropdown lh-1 o-dropdown--no-caret show']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();

    }

}

