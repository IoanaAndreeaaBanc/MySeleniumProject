package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBoxTest {
    WebDriver driver;

    String url = "https://demoqa.com/text-box";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement consentButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p"));
        consentButton.click();

    }

    @Test
    public void testForm() {


        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Banc Ioana Andreea");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("banc.ioana.andreea@gmail.com");

        WebElement currentAdress = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        currentAdress.sendKeys("Cluj-Napoca");

        WebElement permanentAdress = driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));
        permanentAdress.sendKeys("Sibiu");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement message = driver.findElement(By.id("output"));

        String expectedResult =
                        "Name:Banc Ioana Andreea\n" +
                        "Email:banc.ioana.andreea@gmail.com\n" +
                        "Current Address :Cluj-Napoca\n" +
                        "Permananet Address :Sibiu";

        Assert.assertEquals(expectedResult, message.getText());
        Assert.assertTrue(message.getText().contains(expectedResult));
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
