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
        openUrl();
        String contactsCTA = props.getProperty("CONTACTS.CTA.xpath.update");

        waitForLoad();

        driver.findElement(By.xpath(contactsCTA)).click();

        waitForLoad();

        String ContactToBeDeleted = "Akshay Test";
        String deleteContactXpath = "( //*[ text() = '"+ContactToBeDeleted+"'])[1]";

        driver.findElement(By.xpath(deleteContactXpath)).click();

        waitForLoad();

        driver.findElement(By.xpath("//i[@class='fa fa-cog']")).click();

        waitForLoad();

        driver.findElement(By.xpath("(//*[ text() = 'Delete'])[1]")).click();

        waitForLoad();

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    }
}
