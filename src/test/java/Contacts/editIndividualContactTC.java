package Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class editIndividualContactTC extends ContactsBaseTest {
    @Test
    public void editCompanyContact() throws IOException, InterruptedException {
        loginWithValidUser();
        String contactsCTA = props.getProperty("CONTACTS.CTA.xpath.update");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(contactsCTA)).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("( //*[ text() = 'akshay LoginTC.test'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        waitForLoad();

        // Upload the profile picture
        WebElement image = driver.findElement(By.xpath("//div[@class='d-inline-block position-relative opacity-trigger-hover']"));
        WebElement editBtn = driver.findElement(By.xpath("//input[@type='file']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(image);
        actions.moveToElement(editBtn);
        editBtn.sendKeys("C:\\recruitcrm\\img\\sample.png");
    }
}
