package LoginTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class loginBaseTC {
    public static WebDriver driver;
    public static Properties props;

    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date = new Date();

    @BeforeSuite(alwaysRun = true)
    public void baseTCMethod() throws IOException {
        FileReader reader = new FileReader("./src/main/resources/loginLocators.properties");
        props=new Properties();
        System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
        props.load(reader);
    }



    @BeforeMethod(alwaysRun = true)
    public void openUrl() throws IOException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://akshaycrm.odoo.com/web/login");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
