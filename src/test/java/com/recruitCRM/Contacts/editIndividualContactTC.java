package com.recruitCRM.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class editIndividualContactTC extends ContactsBaseTest {
    // Test to edit an individual contact by adding image of the person
    @Test
    public void editCompanyContact() throws IOException, InterruptedException {
        loginWithValidUser();
        String contactsCTA = props.getProperty("CONTACTS.CTA.xpath.update");
        String ContactToBeEdited= "Akshay Test";
        String editContactXpath = "(//*[text()='"+ContactToBeEdited+"'])[1]";
        waitForElementToBeVisibleByXPath(contactsCTA);
        driver.findElement(By.xpath(contactsCTA)).click();

        waitForElementToBeVisibleByXPath(editContactXpath);
        driver.findElement(By.xpath(editContactXpath)).click();


        // Upload the profile picture
        String imageXpath = props.getProperty("CONTACTS.EDIT.Image.xpath");
        String editBtnXpath = props.getProperty("CONTACTS.EDIT.Pencil.xpath");

        waitForElementToBeVisibleByXPath(imageXpath);
        WebElement image = driver.findElement(By.xpath(imageXpath));
        WebElement editBtn = driver.findElement(By.xpath(editBtnXpath));

        Actions actions = new Actions(driver);
        actions.moveToElement(image);
        actions.moveToElement(editBtn);
        editBtn.sendKeys("C:\\recruitcrm\\img\\sample.png");
    }
}
