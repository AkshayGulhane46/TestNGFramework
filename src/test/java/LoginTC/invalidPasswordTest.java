package LoginTC;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class invalidPasswordTest extends LoginBaseTest {

    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports("C:\\recruitcrm\\reports\\"+"ExtentReportResultsInvalidLoginTest.html");
        test = report.startTest("InvalidLoginTest");
    }


    @Test
    public void invalidPasswordTC(){
        String username = LoginBaseTest.props.getProperty("LOGIN.username.xpath");
        String password = LoginBaseTest.props.getProperty("LOGIN.password.xpath");
        String submitBtn = LoginBaseTest.props.getProperty("LOGIN.submit.xpath");
        String validUserName = props.getProperty("VALID.LOGIN.CREDENTIALS.USERNAME");
        String invalidPassword = props.getProperty("INVALID.LOGIN.CREDENTIALS.PASSWORD");
        String errorMessage = props.getProperty("ERROR.MESSAGE.xpath");

        LoginBaseTest.driver.findElement(By.xpath(username)).sendKeys(validUserName);
        test.log(LogStatus.PASS, "Entered Valid UserName");
        LoginBaseTest.driver.findElement(By.xpath(password)).sendKeys(invalidPassword);
        test.log(LogStatus.PASS, "Entered INValid UserName");

        LoginBaseTest.driver.findElement(By.xpath(submitBtn)).click();
        if(LoginBaseTest.driver.findElement(By.xpath(errorMessage)).isDisplayed()){
            test.log(LogStatus.PASS,"Test Passed");
        }else{
            test.log(LogStatus.FAIL,"Test Failed");
        }
    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
