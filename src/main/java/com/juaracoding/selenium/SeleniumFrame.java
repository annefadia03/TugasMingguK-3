package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;

public class SeleniumFrame {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/frames");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(className("main-header")).getText();
        System.out.println("Title Page :" + title);

        //frame
        WebElement frameSamplePage = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameSamplePage);   //harus pakai switchto karena elemennya terdapat di frame

        String txtFrame = driver.findElement(id("sampleHeading")).getText();
        System.out.println(txtFrame);

        //keluar dari frame
        driver.switchTo().defaultContent();

        String descFrame = driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]")).getText();
        System.out.println(descFrame);

        //modal dialog (harus menggunakan selectorsHub untuk copyXpath agar dapat di cklick)
        js.executeScript("window.scrollBy(0,400)");
        System.out.println("scroll");
        driver.findElement(By.xpath("//span[normalize-space()='Modal Dialogs']")).click();
        System.out.println("Modal Dialog Cliked");

        //test small modal
        driver.findElement(By.id("showSmallModal")).click();
        String txtTitleModal = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-sm']")).getText();
        System.out.println(txtTitleModal);
        String txtBodyModal = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(txtBodyModal);

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

