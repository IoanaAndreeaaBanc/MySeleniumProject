package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLogin {

    @Parameters({"usernameP", "passwordP", "errorP"})

    @Test(priority=2, groups = {"smoke", "all"})
    public void loginWithInvalidUser(String username, String password, String error){
        //WebDriver = new ChromeDriver();
        //WebDriver = new FirefoxDriver()Driver();
        //WebDriver = new SafariDriver();
        String url = "https://the-internet.herokuapp.com/login";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();//face ecranul fullsize

        WebElement usernameImput = driver.findElement(By.xpath("//input[@type='text']"));
        usernameImput.sendKeys(username);



       WebElement passwordImput = driver.findElement(By.cssSelector("#password"));
       passwordImput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("flash"));
        String InvalidUserMessageContent = error;
        Assert.assertTrue(errorMessage.getText().contains(InvalidUserMessageContent));

        driver.close();


    }

//    @Test (priority=2, enabled = false)
//    public void loginWithInvalidPassword(){
//        //WebDriver = new SafariDriver();
//        String url = "https://the-internet.herokuapp.com/login";
//        WebDriver driver = new ChromeDriver();
//        driver.get(url);
//        driver.manage().window().maximize();//face ecranul fullsize
//
//        WebElement usernameImput = driver.findElement(By.xpath("//input[@type='text']"));
//        usernameImput.sendKeys("tomsmith");
//
//        WebElement passwordImput = driver.findElement(By.cssSelector("#password"));
//        passwordImput.sendKeys("wrongPassworg");
//
//        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
//        loginButton.click();
//
//        WebElement errorMessage = driver.findElement(By.id("flash"));
//        String invalidPasswordMessageContent = "Your password is invalid!";
//        Assert.assertTrue(errorMessage.getText().contains(invalidPasswordMessageContent));
//
//        driver.close();
//
//
//    }
}
