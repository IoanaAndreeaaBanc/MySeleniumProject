package com.herokuapp;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyPressTest {

    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/key_presses?";
    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void pressKey(){
        WebElement input = driver.findElement(By.id("target"));
        input.click();
        input.sendKeys(Keys.SPACE);

         WebElement result = driver.findElement(By.id("result"));
         String resultText = "You entered: SPACE";
        Assert.assertTrue(result.getText().contains(resultText));
        //System.out.println(actual);

        Assert.assertEquals(result.getText(),resultText);
    }
    @AfterTest(alwaysRun = true)
    public void tearDown(){
        //Inchide pagina

        System.out.println(" Inchide pagina");
        driver.close();
    }

}
