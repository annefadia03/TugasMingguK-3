package com.juaracoding.git;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestGit {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://formy-project.herokuapp.com/form");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String titleHeader = driver.getTitle();
        System.out.println("Title Header: " + titleHeader);

        driver.findElement(By.id("first-name")).sendKeys("Anne");
        driver.findElement(By.id("last-name")).sendKeys("Fadia");
        driver.findElement(By.id("job-title")).sendKeys("Programmer");
        driver.findElement(By.id("radio-button-1")).sendKeys("Gradschool");
        driver.findElement(By.id("checkbox-1")).sendKeys("Famale");
        driver.findElement(By.id("select-menu")).sendKeys("0-1");
        driver.findElement(By.id("datepicker")).sendKeys("09-09-2023");
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        System.out.println("Button Submit Clicked");

        System.out.println("Delay 3 seconds");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");

    }
}
