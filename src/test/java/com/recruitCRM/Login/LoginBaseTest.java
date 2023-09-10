package com.recruitCRM.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginBaseTest {
    public static WebDriver driver;
    public static Properties props;

    @BeforeSuite(alwaysRun = true)
    public void baseTCMethod() throws IOException {
        FileReader reader = new FileReader("./src/main/resources/loginLocators.properties");
        props=new Properties();
        //System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
        props.load(reader);
    }

    @BeforeMethod(alwaysRun = true)
    public void openUrl() throws IOException {
        setupChrome();
        driver.get("https://akshaycrm.odoo.com/web/login");
    }

    public void setupChrome(){
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
