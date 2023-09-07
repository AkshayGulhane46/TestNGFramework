package LoginTC;

import LoginTC.loginBaseTC;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class validLoginTC extends loginBaseTC {
    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports("C:\\recruitcrm\\reports\\"+"ExtentReportResultsvalidLoginTest.html");
        test = report.startTest("validLoginTest");
    }

    @Test(testName = "validLoginTest")
    public void validLogin() throws IOException {
        String username = loginBaseTC.props.getProperty("LOGIN.username.xpath");
        String password = loginBaseTC.props.getProperty("LOGIN.password.xpath");
        String submitBtn = loginBaseTC.props.getProperty("LOGIN.submit.xpath");
        loginBaseTC.driver.findElement(By.xpath(username)).sendKeys("akshaytest345@gmail.com");
        test.log(LogStatus.PASS, "Entered Valid UserName");
        loginBaseTC.driver.findElement(By.xpath(password)).sendKeys("LenovoFlex2");
        test.log(LogStatus.PASS, "Entered Valid Password");
        loginBaseTC.driver.findElement(By.xpath(submitBtn)).click();
        test.log(LogStatus.PASS, "Clicked on Login Button");
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
