package Contacts;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class createCompanyContactTC extends ContactsBaseTest{
    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports("C:\\recruitcrm\\reports\\"+"createCompanyTC.html");
        test = report.startTest("createCompanyTC");
    }
    // Test to create a new company contact
    @Test
    public void createCompanyContact() throws IOException, InterruptedException {
        loginWithValidUser();
        String contactsCTA = props.getProperty("CONTACTS.CTA.xpath.update");
        String companyRadioCTA = props.getProperty("CONTACTS.COMPANY.Radio.CTA.xpath");
        String companyNameINPUT = props.getProperty("CONTACTS.COMPANY.Name.INPUT.xpath");
        String companyPhoneINPUT = props.getProperty("CONTACTS.COMPANY.Phone.INPUT.xpath");
        String companyCityNameInput = props.getProperty("CONTACTS.COMPANY.City.INPUT.xpath");
        String companyStateNameInput = props.getProperty("CONTACTS.COMPANY.State.INPUT.xpath");
        String SaveBtn = props.getProperty("CONTACTS.COMPANY.Save.Btn.xpath");
        String NewContactBtn = props.getProperty("CONTACTS.NEW.Btn.xpath");

        clickOnElementUsingXpath(contactsCTA);
        test.log(LogStatus.PASS, "Clicked on Contact CTA");

        clickOnElementUsingXpath(NewContactBtn);
        test.log(LogStatus.PASS, "Clicked on New Contact Button");

        waitForElementToBeVisibleByCssSelector(companyRadioCTA);
        driver.findElement(By.cssSelector(companyRadioCTA)).click();
        test.log(LogStatus.PASS, "Clicked on Company Radio Button");

        waitForElementToBeVisibleByXPath(companyNameINPUT);
        driver.findElement(By.xpath(companyNameINPUT)).sendKeys("Test Company");
        test.log(LogStatus.PASS, "Entered Company Name");

        waitForElementToBeVisibleByXPath(companyPhoneINPUT);
        driver.findElement(By.xpath(companyPhoneINPUT)).sendKeys("123123123");
        test.log(LogStatus.PASS, "Entered Company Phone Number");

        waitForElementToBeVisibleByXPath(companyCityNameInput);
        driver.findElement(By.xpath(companyCityNameInput)).sendKeys("Nagpur");
        test.log(LogStatus.PASS, "Entered Company City");

        waitForElementToBeVisibleByXPath(companyStateNameInput);
        driver.findElement(By.xpath(companyStateNameInput)).sendKeys("Maharashtra");
        driver.findElement(By.xpath(companyStateNameInput)).sendKeys(Keys.ENTER);
        test.log(LogStatus.PASS, "Selected Company State from Dropdown");

        waitForElementToBeVisibleByXPath(SaveBtn);
        driver.findElement(By.xpath(SaveBtn)).click();
        test.log(LogStatus.PASS, "Test Completed");

    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
