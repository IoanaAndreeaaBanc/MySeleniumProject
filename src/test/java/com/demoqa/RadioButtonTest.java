package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtonTest {
    WebDriver driver;

    String url = "https://demoqa.com/radio-button";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement consentButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p"));
        consentButton.click();
    }

    @Test
    public void yesRadioButtonTest()
    {
        WebElement yesRadioButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label"));
        yesRadioButton.click();

        WebElement resultMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p"));

        String expectedResult ="You have selected Yes";
        Assert.assertEquals(expectedResult, resultMessage.getText());
        Assert.assertTrue(resultMessage.getText().contains(expectedResult));
    }

    @Test
    public void impressiveRadioButtonTest()
    {
        WebElement impressiveRadioButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label"));
        impressiveRadioButton.click();

        WebElement resultMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p"));

        String expectedResult ="You have selected Impressive";
        Assert.assertEquals(expectedResult, resultMessage.getText());
        Assert.assertTrue(resultMessage.getText().contains(expectedResult));
    }


    @AfterTest
    public void tearDown(){
        driver.close();}



}