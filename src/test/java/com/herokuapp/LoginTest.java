package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;


public class LoginTest {
   // @BeforeTest
   // public static void
    // declar driverul si url la nivel de clasa si in set up ii dam doar valoarea

    @Test(testName = "Login test")
    public void login() {
        //1. deschide pagina Form Autehtification

        System.out.println("deschide pagina Form Autentification");
        String url = "https://the-internet.herokuapp.com/login";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();//face ecranul fullsize
        System.out.println("Asteapta 2 secunde");
        sleep(2000);


        //2. clic username and enter user: tomsmith

        System.out.println("Username");
        WebElement usernameImput = driver.findElement(By.id("username"));
        usernameImput.sendKeys("tomsmith");
        sleep(2000);

        //3. clik password and enter:"SuperSecretPassword!"

        System.out.println("Parola");
        WebElement passwordImput = driver.findElement(By.id("password"));
        passwordImput.sendKeys("SuperSecretPassword!");
        sleep(2000);

        //4. click login button

        System.out.println("Click login button");
        //WebElement loginButton = driver.findElement(By.className("radius"));
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        sleep(2000);

        //5. expected results: "Welcome to the Secure Area" is dispalyed

        System.out.println("Verifica continutul subheaderului");
        WebElement secureAreaSubheder = driver.findElement(By.className("subheader"));
        String subheaderContent = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertTrue(secureAreaSubheder.isDisplayed());
        Assert.assertEquals(subheaderContent,secureAreaSubheder.getText());

        String secureUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), secureUrl);

        WebElement successMesage = driver.findElement(By.id("flash"));
        String successMesageContent = "You logged into a secure area!";
        Assert.assertTrue(successMesage.getText().contains(successMesageContent));

        // Inchide pagina

        System.out.println("Inchide pagina");
        driver.close();
    }

   // @AfterTest (always run = true)
    // public void tearDown(){
    // inchide pagina
    //System.out.println("Inchide pagina");
    //driver.close();


    public static void sleep(int miliseconds) {

        try {
            Thread.sleep((miliseconds));
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }
}

