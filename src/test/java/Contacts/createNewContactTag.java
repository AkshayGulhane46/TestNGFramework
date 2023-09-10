package Contacts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class createNewContactTag extends ContactsBaseTest{
    @Test
    public void createNewContactTag() throws IOException {
       loginWithValidUser();


       String contactsCTA = props.getProperty("CONTACTS.CTA.xpath.update");
       String ConfigurationBtn = props.getProperty("CONFIGURATION.Btn.xpath");
       String ContactTageBtn = props.getProperty("CONFIGURATION.CONTACTS.TAGS.Option.xpath");
       String NewContactTagBtn = props.getProperty("CONFIGURATION.NEW.btn.xpath");
       String ContactTagName = props.getProperty("CONFIGURATION.CONTACT.TAG.Name.xpath");
       String SaveBtn = props.getProperty("CONFIGURATION.CONTACT.TAG.Save.Btn.xpath");

       waitForElementToBeVisibleByXPath(contactsCTA);
       driver.findElement(By.xpath(contactsCTA)).click();
       clickOnElementUsingXpath(ConfigurationBtn);
       clickOnElementUsingXpath(ContactTageBtn);
       clickOnElementUsingXpath(NewContactTagBtn);
       waitForElementToBeVisibleByXPath(ContactTagName);
       driver.findElement(By.xpath(ContactTagName)).sendKeys("CustomTag");
       clickOnElementUsingXpath(SaveBtn);


    }
}
