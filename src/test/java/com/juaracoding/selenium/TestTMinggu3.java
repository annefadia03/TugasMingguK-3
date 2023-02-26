package com.juaracoding.selenium;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


import static org.openqa.selenium.By.className;

public class TestTMinggu3 {
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
        driver.get("https://shop.demoqa.com/shop/");
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
        String txtPassword = driver.findElement(By.xpath("//@id='password']")).getText();
        Assert.assertTrue(txtPassword.contains("1403Pane");
    }

    @Test
    public void tesAddCart(){
        driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//a[1]//img[1]")).click();
        System.out.println("sow item");
        WebElement selectColor =  driver.findElement(By.id("pa_color"));
        Select color = new Select(selectColor);
        driver.findElement(By.id("pa_size"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//*[@id=\"product-1281\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]/i")).click();
        String AddToCart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).getText();
        System.out.println(AddToCart);
        String Heel = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[3]/div/span[1]")).getText();
        Assert.assertTrue(Heel.contains("shoes"));
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
