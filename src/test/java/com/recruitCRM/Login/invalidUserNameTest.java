package com.recruitCRM.Login;


import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class invalidUserNameTest extends LoginBaseTest {

    @Test
    public void invalidUserNameTC(){
        String username = props.getProperty("LOGIN.username.xpath");
        String password = props.getProperty("LOGIN.password.xpath");
        String submitBtn = props.getProperty("LOGIN.submit.xpath");
        String invalidUserName = props.getProperty("INVALID.LOGIN.CREDENTIALS.USERNAME");
        String validPassword = props.getProperty("VALID.LOGIN.CREDENTIALS.PASSWORD");
        String errorMessage = props.getProperty("ERROR.MESSAGE.xpath");

        driver.findElement(By.xpath(username)).sendKeys(invalidUserName);
        driver.findElement(By.xpath(password)).sendKeys(validPassword);
        driver.findElement(By.xpath(submitBtn)).click();
    }



}
