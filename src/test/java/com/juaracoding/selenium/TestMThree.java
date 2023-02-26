package com.juaracoding.selenium;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


import static org.openqa.selenium.By.className;

public class TestMThree {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void testUrl() {
        driver.get("https://shop.demoqa.com/my-account/");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
        String titleHeader = driver.findElement(className("main-header")).getText();
        System.out.println("Title Page :" + titleHeader);
        //step verify
        Assert.assertEquals("Shop.DemoQA", titleHeader);
    }

    @Test
    public void tesFormIdentity() {
        driver.findElement(By.id("username")).sendKeys("Annefadia143");
        driver.findElement(By.id("password")).sendKeys("1403Pane");
        driver.findElement(By.name("login")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        String txtName = driver.findElement(By.xpath("//input[@id='username']")).getText();
        Assert.assertTrue(txtName.contains("AnneFadia143"));
    }

    @AfterClass
    public void quitBrowser() {
        System.out.println("Delay 3 second");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Quit Browser");
    }

}
