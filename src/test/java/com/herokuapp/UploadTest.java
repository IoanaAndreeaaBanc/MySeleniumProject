package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadTest {
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/upload";

    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void testUpload(){
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys("C:\\Users\\banci\\IdeaProjects\\MySeleniumProject\\src\\test\\Resources\\testbox.xml");

        WebElement fileSubmit = driver.findElement(By.id("file-submit"));
        fileSubmit.click();

        WebElement message = driver.findElement(By.xpath("//h3"));
        String expectedMessage = "File Uploaded!";
        Assert.assertTrue(message.getText().contains(expectedMessage));

    }
    @AfterTest(alwaysRun = true)
    public void tearDown(){
        //Inchide pagina

        System.out.println(" Inchide pagina");
        driver.close();
    }
}
