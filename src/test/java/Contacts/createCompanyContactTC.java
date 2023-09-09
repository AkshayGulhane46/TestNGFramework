package Contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class createCompanyContactTC extends ContactsBaseTest{
    @Test
    public void createCompanyContact() throws IOException, InterruptedException {
        loginWithValidUser();
        String contactsCTA = props.getProperty("CONTACTS.CTA.xpath.update");
        String IndividualRadioCTA = props.getProperty("CONTACTS.INDIVIDUAL.Radio.CTA.xpath");
        String IndividualNameINPUT = props.getProperty("CONTACTS.INDIVIDUAL.Name.INPUT.xpath");
        String IndividualCompanyNameINPUT = props.getProperty("CONTACTS.INDIVIDUAL.CompanyName.INPUT.xpath");
        String IndividualCityNameInput = props.getProperty("CONTACTS.INDIVIDUAL.City.INPUT.xpath");
        String IndividualStateNameInput = props.getProperty("CONTACTS.INDIVIDUAL.State.INPUT.xpath");
        String SaveBtn = props.getProperty("CONTACTS.INDIVIDUAL.Save.Btn.xpath");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(contactsCTA)).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://akshaycrm.odoo.com/web#cids=1&menu_id=110&action=146&model=res.partner&view_type=form");
        driver.findElement(By.xpath(IndividualRadioCTA)).click();
        driver.findElement(By.xpath(IndividualNameINPUT)).sendKeys("Test Company");
        driver.findElement(By.xpath(IndividualCompanyNameINPUT)).sendKeys("ABC corporation");
        driver.findElement(By.xpath(IndividualCityNameInput)).sendKeys("Nagpur");
        driver.findElement(By.xpath(IndividualStateNameInput)).sendKeys("Maharashtra");
        driver.findElement(By.xpath(IndividualStateNameInput)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(SaveBtn)).click();
    }
}
