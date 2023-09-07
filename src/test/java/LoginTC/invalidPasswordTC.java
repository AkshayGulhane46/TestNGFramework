package LoginTC;

import LoginTC.loginBaseTC;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class invalidPasswordTC extends loginBaseTC {

    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports("C:\\recruitcrm\\reports\\"+"ExtentReportResultsInvalidLoginTest.html");
        test = report.startTest("INvalidLoginTest");
    }


    @Test
    public void invalidPasswordTC(){
        String username = loginBaseTC.props.getProperty("LOGIN.username.xpath");
        String password = loginBaseTC.props.getProperty("LOGIN.password.xpath");
        String submitBtn = loginBaseTC.props.getProperty("LOGIN.submit.xpath");
        loginBaseTC.driver.findElement(By.xpath(username)).sendKeys("akshaytest345@gmail.com");
        test.log(LogStatus.PASS, "Entered Valid UserName");
        loginBaseTC.driver.findElement(By.xpath(password)).sendKeys("Lenovoex2");
        test.log(LogStatus.PASS, "Entered INValid UserName");

        loginBaseTC.driver.findElement(By.xpath(submitBtn)).click();
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
