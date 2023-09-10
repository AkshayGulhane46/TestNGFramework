package LoginTC;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class invalidUserNameTest extends LoginBaseTest {
    static ExtentTest test;
    static ExtentReports report;
    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports("C:\\recruitcrm\\reports\\"+"ExtentReportResultsInvalidUserNamePasswordTC.html");
        test = report.startTest("InvalidUserNamePasswordTC");
    }
    @Test
    public void invalidUserNameTC(){
        String username = LoginBaseTest.props.getProperty("LOGIN.username.xpath");
        String password = LoginBaseTest.props.getProperty("LOGIN.password.xpath");
        String submitBtn = LoginBaseTest.props.getProperty("LOGIN.submit.xpath");
        String invalidUserName = props.getProperty("INVALID.LOGIN.CREDENTIALS.USERNAME");
        String validPassword = props.getProperty("VALID.LOGIN.CREDENTIALS.PASSWORD");
        String errorMessage = props.getProperty("ERROR.MESSAGE.xpath");

        LoginBaseTest.driver.findElement(By.xpath(username)).sendKeys(invalidUserName);
        test.log(LogStatus.PASS,"Entered Invalid UserName");
        LoginBaseTest.driver.findElement(By.xpath(password)).sendKeys(validPassword);
        test.log(LogStatus.PASS,"Entered Invalid Password");
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
