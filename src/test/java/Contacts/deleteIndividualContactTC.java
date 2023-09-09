package Contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class deleteIndividualContactTC  extends ContactsBaseTest{
    @Test
    public void editCompanyContact() throws IOException, InterruptedException {
        loginWithValidUser();
        String contactsCTA = props.getProperty("CONTACTS.CTA.xpath.update");
        String deleteGearIcon = props.getProperty("CONTACTS.DELETE.Gear.Icon.xpath");
        String deleteLink = props.getProperty("CONTACTS.DELETE.Delete.link");
        String confirmBtn = props.getProperty("CONTACTS.DELETE.Confirm.btn");
        waitForLoad();

        driver.findElement(By.xpath(contactsCTA)).click();

        waitForLoad();

        String ContactToBeDeleted = "Akshay Test";
        String deleteContactXpath = "(//*[text()='"+ContactToBeDeleted+"'])[1]";

        waitForElementToBeVisibleByXPath(deleteContactXpath);
        driver.findElement(By.xpath(deleteContactXpath)).click();


        waitForElementToBeVisibleByXPath(deleteGearIcon);
        driver.findElement(By.xpath(deleteGearIcon)).click();


        waitForElementToBeVisibleByXPath(deleteLink);
        driver.findElement(By.xpath(deleteLink)).click();


        waitForElementToBeVisibleByXPath(confirmBtn);
        driver.findElement(By.xpath(confirmBtn)).click();
    }
}
