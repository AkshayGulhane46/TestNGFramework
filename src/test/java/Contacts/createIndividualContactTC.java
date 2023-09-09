package Contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class createIndividualContactTC extends ContactsBaseTest{
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
        waitForElementToBeVisibleByXPath(IndividualNameINPUT);
        driver.findElement(By.xpath(IndividualNameINPUT)).sendKeys("Akshay Test");
        waitForElementToBeVisibleByXPath(IndividualCompanyNameINPUT);
        driver.findElement(By.xpath(IndividualCompanyNameINPUT)).sendKeys("ABC corporation");
        waitForElementToBeVisibleByXPath(IndividualCityNameInput);
        driver.findElement(By.xpath(IndividualCityNameInput)).sendKeys("Nagpur");
        waitForElementToBeVisibleByXPath(IndividualStateNameInput);
        driver.findElement(By.xpath(IndividualStateNameInput)).sendKeys("Maharashtra");
        waitForElementToBeVisibleByXPath(IndividualStateNameInput);
        driver.findElement(By.xpath(IndividualStateNameInput)).sendKeys(Keys.ENTER);
        waitForElementToBeVisibleByXPath(SaveBtn);
        driver.findElement(By.xpath(SaveBtn)).click();
        driver.navigate().refresh();
    }
}
