package com.recruitCRM.Contacts;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class createIndividualContactTC extends ContactsBaseTest{

    // Test to create a new individual contact
    @Test
    public void createIndividualContact() throws IOException, InterruptedException {
        loginWithValidUser();
        String contactsCTA = props.getProperty("CONTACTS.CTA.xpath.update");
        String IndividualRadioCTA = props.getProperty("CONTACTS.INDIVIDUAL.Radio.CTA.xpath");
        String IndividualNameINPUT = props.getProperty("CONTACTS.INDIVIDUAL.Name.INPUT.xpath");
        String IndividualCompanyNameINPUT = props.getProperty("CONTACTS.INDIVIDUAL.CompanyName.INPUT.xpath");
        String IndividualCityNameInput = props.getProperty("CONTACTS.INDIVIDUAL.City.INPUT.xpath");
        String IndividualStateNameInput = props.getProperty("CONTACTS.INDIVIDUAL.State.INPUT.xpath");
        String SaveBtn = props.getProperty("CONTACTS.INDIVIDUAL.Save.Btn.xpath");
        waitForLoad();
        waitForElementToBeVisibleByXPath(contactsCTA);
        driver.findElement(By.xpath(contactsCTA)).click();
        driver.get("https://akshaycrm.odoo.com/web#cids=1&menu_id=110&action=146&model=res.partner&view_type=form");
        waitForLoad();
        waitForElementToBeVisibleByCssSelector(IndividualRadioCTA);
        driver.findElement(By.cssSelector(IndividualRadioCTA)).click();
       // test.log(LogStatus.PASS, "Clicked on Individual Radio Button");
        waitForElementToBeVisibleByXPath(IndividualNameINPUT);
        driver.findElement(By.xpath(IndividualNameINPUT)).sendKeys("Akshay Test");
      //  test.log(LogStatus.PASS, "Searched Using Name");
        waitForElementToBeVisibleByXPath(IndividualCompanyNameINPUT);
        driver.findElement(By.xpath(IndividualCompanyNameINPUT)).sendKeys("ABC corporation");
       // test.log(LogStatus.PASS, "Entered Company Name");
        waitForElementToBeVisibleByXPath(IndividualCityNameInput);
        driver.findElement(By.xpath(IndividualCityNameInput)).sendKeys("Nagpur");
      //  test.log(LogStatus.PASS, "Entered City Name");
        waitForElementToBeVisibleByXPath(IndividualStateNameInput);
        driver.findElement(By.xpath(IndividualStateNameInput)).sendKeys("Maharashtra");
        waitForElementToBeVisibleByXPath(IndividualStateNameInput);
        driver.findElement(By.xpath(IndividualStateNameInput)).sendKeys(Keys.ENTER);
      //  test.log(LogStatus.PASS, "Saved Company Name");
        waitForElementToBeVisibleByXPath(SaveBtn);
        driver.findElement(By.xpath(SaveBtn)).click();
       // test.log(LogStatus.PASS, "Test Complated");
        driver.navigate().refresh();
    }


}
