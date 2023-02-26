package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TMinggu3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://shop.demoqa.com/my-account/");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String titleHeader = driver.getTitle();
        System.out.println("Title Header: " + titleHeader);

        //locator name Login
        driver.findElement(By.id("username")).sendKeys("Annefadia143");
        driver.findElement(By.id("password")).sendKeys("1403Pane");
        driver.findElement(By.name("login")).click();
        System.out.println("Button Login Clicked");

        js.executeScript("window.scrollBy(0,400)");
        System.out.println("scroll");
        driver.switchTo().defaultContent();

        //add toCart
        driver.get("https://shop.demoqa.com/shop/");
        driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//a[1]//img[1]")).click();
        System.out.println("sow item");
        WebElement selectColor =  driver.findElement(By.id("pa_color"));
        Select color = new Select(selectColor);
        driver.findElement(By.id("pa_size"));
        js.executeScript("window.scrollBy(0,400)");
        System.out.println("scroll");
        driver.findElement(By.xpath("//*[@id=\"product-1281\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]/i")).click();
        String AddToCart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).getText();
        System.out.println(AddToCart);

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
