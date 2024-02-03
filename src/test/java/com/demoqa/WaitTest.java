package com.demoqa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest {
    WebDriver driver;

    String url  = "https://demoqa.com/alerts";


        @BeforeTest
        public void setUp() {

            driver =new ChromeDriver();
            driver.get(url);
            driver.manage().window().fullscreen();
            WebElement consentButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p"));
            consentButton.click();

    }
    @Test

    public void WaitTest(){

        WebElement clickMe = driver.findElement(By.id("timerAlertButton"));
        clickMe.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String text = alert.getText();
        System.out.println((text));
        alert.accept();
    }

    @Test
    public void wait2Test(){
            WebElement clickMe2 = driver.findElement(By.id("confirmButton"));
            clickMe2.click();
            sleep(4000);
           // WebElement succesMessage = driver.findElement(By.id("confirmResult"));
           // String expectedResult = "You are selected Ok";
       // Assert.assertTrue(succesMessage.getText().contains(expectedResult));
    }
    @AfterTest
    public void tearDown(){
         driver.close();
    }

    public static void sleep(int miliseconds) {

        try {
            Thread.sleep((miliseconds));
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

}