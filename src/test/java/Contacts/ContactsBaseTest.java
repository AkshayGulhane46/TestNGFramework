package Contacts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ContactsBaseTest{
    public static WebDriver driver;
    public static Properties props;

    @BeforeMethod(alwaysRun = true)
    public void baseTCMethod() throws IOException {
        FileReader reader = new FileReader("./src/main/resources/contactsLocators.properties");
        props=new Properties();
        // System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
        props.load(reader);
    }

    public static void loginWithValidUser() throws IOException {
        // To open new instance of Chrome browser

        setupChrome();
        // To set properties of the variable data
        String username = props.getProperty("LOGIN.username.xpath");
        String password = props.getProperty("LOGIN.password.xpath");
        String submitBtn = props.getProperty("LOGIN.submit.xpath");
        String loginURL = props.getProperty("LOGIN.URL");
        String ValidUserName = props.getProperty("LOGIN.Valid.UserName");
        String ValidPassword = props.getProperty("Login.Valid.Password");

        // To navigate in file
        driver.get(loginURL);
        driver.findElement(By.xpath(username)).sendKeys(ValidUserName);
        driver.findElement(By.xpath(password)).sendKeys(ValidPassword);
        driver.findElement(By.xpath(submitBtn)).click();
    }

    // Wait Method for page Load
    public void  waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Set a reasonable timeout
        wait.until(webDriver -> {
            String documentReadyState = (String)((JavascriptExecutor)webDriver).executeScript("return document.readyState");
            return "complete".equals(documentReadyState);
        });
    }
    // Wait method for element to be displayed by xpath
    public static void waitForElementToBeVisibleByXPath( String xpathExpression) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
    }

    public static void clickOnElementUsingXpath(String locator){
        waitForElementToBeVisibleByXPath(locator);
        WebElement element = driver.findElement(By.xpath(locator));
        element.click();
    }
    // Wait method for element to be displayed by css Selector
    public static void waitForElementToBeVisibleByCssSelector( String cssExpression) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssExpression
        )));
    }

    public static void setupChrome(){
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterTest
    public void tearDown(){
        driver.close();
        System.out.println("Test Complated!");
    }
}
