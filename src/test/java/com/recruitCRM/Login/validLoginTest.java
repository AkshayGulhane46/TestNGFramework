package com.recruitCRM.Login;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.recruitCRM.config.ExtentReportManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class validLoginTest extends LoginBaseTest {
    private ExtentTest test;

    @Test(testName = "validLoginTest")
    public void validLogin() throws IOException {
        test = ExtentReportManager.createTest("myTestMethod");
        String username = props.getProperty("LOGIN.username.xpath");
        String password = props.getProperty("LOGIN.password.xpath");
        String submitBtn = props.getProperty("LOGIN.submit.xpath");
        String validUserName = props.getProperty("VALID.LOGIN.CREDENTIALS.USERNAME");
        String validPassword = props.getProperty("VALID.LOGIN.CREDENTIALS.PASSWORD");

        driver.findElement(By.xpath(username)).sendKeys(validUserName);
        test.log(Status.PASS,"Entered Valid UserName");
        driver.findElement(By.xpath(password)).sendKeys(validPassword);
       test.log(Status.PASS, "Entered Valid Password");
        driver.findElement(By.xpath(submitBtn)).click();
        test.log(Status.PASS, "Clicked on Login Button");

    }


}
