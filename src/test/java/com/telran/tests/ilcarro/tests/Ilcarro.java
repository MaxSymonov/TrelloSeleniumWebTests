package com.telran.tests.ilcarro.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ilcarro extends HelperBaseIc {

    @BeforeClass
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\GoogleChromePortable64\\App\\Chrome-bin\\chrome.exe");
        wd = new ChromeDriver(options);
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    @Test
    public void addCar() throws InterruptedException {
        login();
        Thread.sleep(5000);
        waitElementLocated(By.xpath("//ul[@class='header__nav desktop']//li[2]/a"));
        waitElementLocatedType(By.xpath("//input[@name='country']"), "Israel");
        waitElementLocatedType(By.xpath("//input[@name='address']"), "Haifa");
        waitElementLocatedType(By.xpath("//input[@name='distance_included']"), "500");
        waitElementLocatedType(By.xpath("//input[@name='serial_number']"), "21431590");
        waitElementLocatedType(By.xpath("//input[@name='make']"), "Toyota");
        waitElementLocatedType(By.xpath("//input[@name='model']"), "RAV4");
        waitElementLocatedType(By.xpath("//input[@name='year']"), "2015");
        waitElementLocatedType(By.xpath("//input[@name='engine']"), "V8");
        waitElementLocatedType(By.xpath("//input[@name='fuel_consumption']"), "10");
        waitElementLocatedType(By.xpath("//input[@name='fuel']"), "gas");
        waitElementLocatedType(By.xpath("//input[@name='gear']"), "transmission");
        waitElementLocatedType(By.xpath("//input[@name='wheels_drive']"), "4WD");
        waitElementLocatedType(By.xpath("//input[@name='horsepower']"), "100");
        waitElementLocatedType(By.xpath("//input[@name='torque']"), "100");
        waitElementLocatedType(By.xpath("//input[@name='doors']"), "5");
        waitElementLocatedType(By.xpath("//input[@name='seats']"), "5");
        waitElementLocatedType(By.xpath("//input[@name='car_class']"), "A");
        waitElementLocatedType(By.xpath("//textarea[@name='about']"), "Some description");
        waitElementLocatedType(By.xpath("//input[@name='features']"), "Air conditioner");
        waitElementLocatedType(By.xpath("//input[@name='price_per_day']"), "100");

        click(By.xpath("//input[@value='Submit']"));

        Thread.sleep(3000);
        click(By.xpath("//ul[@class='header__nav desktop']//li[4]/a"));

    }

    @AfterClass(enabled = false)
    public void tearDown() {
        wd.quit();
    }
}
