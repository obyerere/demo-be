package com.grokonez.uitests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class TesyUI_001
{
    @Test
    public void loginTest()
    {
        String baseURL = "http://localhost:4200/home";
        System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("jonsnow");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("jonsnow");
        driver.findElement(By.xpath("//input[@name='tenant']")).sendKeys("jonsnow");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        Assert.assertThat(driver.findElement(By.xpath("//body//p[1]")).getText(), containsString("jonsnow"));
        driver.quit();
    }
}
