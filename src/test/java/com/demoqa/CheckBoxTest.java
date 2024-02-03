package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxTest {

    WebDriver driver;

    String url = "https://demoqa.com/checkbox";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        WebElement consentButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p"));
        consentButton.click();

        String url = "https://demoqa.com/checkbox";



    }

    @Test
    public void testCheckbox()
    {
        WebElement expandButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[1]"));
        expandButton.click();

        WebElement desktopChekbox = driver.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[1]/span[@class='rct-text']/label/span[@class='rct-title']"));
        desktopChekbox.click();

        WebElement collapseButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[2]"));
        collapseButton.click();

        WebElement resultMessage = driver.findElement(By.xpath("//*[@id=\"result\"]"));

        String expectedResult = "You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands";

        System.out.println(resultMessage.getText());

        Assert.assertEquals(resultMessage.getText(), expectedResult );
        Assert.assertTrue(resultMessage.getText().contains(expectedResult));
    }

    @AfterTest
    public void tearDown(){
       // driver.close();
    }


}
