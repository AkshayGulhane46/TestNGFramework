package LoginTC;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class validLoginTest extends LoginBaseTest {
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
        String username = LoginBaseTest.props.getProperty("LOGIN.username.xpath");
        String password = LoginBaseTest.props.getProperty("LOGIN.password.xpath");
        String submitBtn = LoginBaseTest.props.getProperty("LOGIN.submit.xpath");
        String validUserName = props.getProperty("VALID.LOGIN.CREDENTIALS.USERNAME");
        String validPassword = props.getProperty("VALID.LOGIN.CREDENTIALS.PASSWORD");

        LoginBaseTest.driver.findElement(By.xpath(username)).sendKeys(validUserName);
        test.log(LogStatus.PASS, "Entered Valid UserName");
        LoginBaseTest.driver.findElement(By.xpath(password)).sendKeys(validPassword);
        test.log(LogStatus.PASS, "Entered Valid Password");
        LoginBaseTest.driver.findElement(By.xpath(submitBtn)).click();
        test.log(LogStatus.PASS, "Clicked on Login Button");

    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
