package com.recruitCRM.Contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class createCompanyContactTC extends ContactsBaseTest{

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

        clickOnElementUsingXpath(NewContactBtn);

        waitForElementToBeVisibleByCssSelector(companyRadioCTA);
        driver.findElement(By.cssSelector(companyRadioCTA)).click();

        waitForElementToBeVisibleByXPath(companyNameINPUT);
        driver.findElement(By.xpath(companyNameINPUT)).sendKeys("Test Company");

        waitForElementToBeVisibleByXPath(companyPhoneINPUT);
        driver.findElement(By.xpath(companyPhoneINPUT)).sendKeys("123123123");

        waitForElementToBeVisibleByXPath(companyCityNameInput);
        driver.findElement(By.xpath(companyCityNameInput)).sendKeys("Nagpur");

        waitForElementToBeVisibleByXPath(companyStateNameInput);
        driver.findElement(By.xpath(companyStateNameInput)).sendKeys("Maharashtra");
        driver.findElement(By.xpath(companyStateNameInput)).sendKeys(Keys.ENTER);

        waitForElementToBeVisibleByXPath(SaveBtn);
        driver.findElement(By.xpath(SaveBtn)).click();

    }


}
