package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest {

 @Test
 public void logout(){
     String url = "https://the-internet.herokuapp.com/login";
     WebDriver driver = new ChromeDriver();
     driver.get(url); // deschide url.ul dat
     driver.manage().window().maximize();//face ecranul fullsize

     WebElement usernameImput = driver.findElement(By.id("username"));
     usernameImput.sendKeys("tomsmith");

     WebElement passwordImput = driver.findElement(By.id("password"));
     passwordImput.sendKeys("SuperSecretPassword!");

     WebElement loginButton = driver.findElement(By.className("radius"));
     loginButton.click();


     WebElement logoutButton = driver.findElement(By.className("radius"));
    logoutButton.click();

     WebElement succesMessage = driver.findElement(By.id(("flash")));
     String succesMessageContent = "You logged out of the secure area!";
     Assert.assertTrue(succesMessage.getText().contains(succesMessageContent));

     driver.close();







 }
}
