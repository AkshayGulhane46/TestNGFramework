package com.recruitCRM.Login;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class invalidPasswordTest extends LoginBaseTest {

    @Test
    public void invalidPasswordTC(){
        String username = props.getProperty("LOGIN.username.xpath");
        String password = props.getProperty("LOGIN.password.xpath");
        String submitBtn = props.getProperty("LOGIN.submit.xpath");
        String validUserName = props.getProperty("VALID.LOGIN.CREDENTIALS.USERNAME");
        String invalidPassword = props.getProperty("INVALID.LOGIN.CREDENTIALS.PASSWORD");
        String errorMessage = props.getProperty("ERROR.MESSAGE.xpath");

        driver.findElement(By.xpath(username)).sendKeys(validUserName);
        //test.log(LogStatus.PASS, "Entered Valid UserName");
        driver.findElement(By.xpath(password)).sendKeys(invalidPassword);
        //test.log(LogStatus.PASS, "Entered INValid UserName");

        driver.findElement(By.xpath(submitBtn)).click();
        if(driver.findElement(By.xpath(errorMessage)).isDisplayed()){
          //  test.log(LogStatus.PASS,"Test Passed");
        }else{
            //test.log(LogStatus.FAIL,"Test Failed");
        }
    }


}
