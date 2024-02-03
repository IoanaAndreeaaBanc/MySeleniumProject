package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.dom.model.ShapeOutsideInfo;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    private String url = "https://www.saucedemo.com/";

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.get(url);
    }


    @Test
    public void loginWithValidCredentials(){
        // 1. Deschide pagina de autentificare

        System.out.println("Deschide pagina de autentificare");
        driver.manage().window().maximize();
        sleep(1000);
        System.out.println("Asteapta 1 secunda");

        //2. Click username and enter user: standard_user

        System.out.println("Username");
        WebElement userInput = driver.findElement(By.id("user-name"));
        userInput.sendKeys("standard_user");
        sleep(1000);
        System.out.println("Asteapta 1 secunda");

        //3 .Click password and enter password: secret_sauce

        System.out.println("Password");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        sleep(2000);
        System.out.println("Asteapta 2 secunda");

        //4.click login button

        System.out.println("Click login button");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        sleep(2000);

        //5. Se verifica daca userul este logat

        String secureUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), secureUrl);

    }

    @AfterTest
    public void afterTest(){
        System.out.println("Inchide pagina");
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
