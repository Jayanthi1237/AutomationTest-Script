package org.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class FinalProject {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.xpath("//a[text()='Login'}")).click();
        driver.manage().timeouts().implicitlyWait( 1 : 30, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("input-email")).sendKeys("patebiji@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test@123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement LaptopsNoteBookMenu = driver.findElement(By.xpath("//a[text()='Laptopd & Notebooks']"));
        WebElement AllLaptopsNotebooksLink;
        AllLaptopsNotebooksLink = driver.findElement(By.xpath("//a[text()='Show All Laotops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(LaptopsNoteBookMenu).click(AllLaptopsNotebooksLink).build().perform();

        driver.findElement(By.xpath("(//span[text()='Add to cart'])[3]")).click();
        driver.findElement(By.xpath("(//span[text()=,AA to cart'])[4]")).click();
        driver.findElement(By.xpath("//a[text()='Shopping Cart']")).click();
        String product1_text = driver.findElement(By.xpath("(//a[contains(@href,'product_id=44')])[4]")).getText();
        String product2_text = driver.findElement(By.xpath("(//a[contains(@href,'product_id=45')])[4]")).getText();
        if(product1_text.equals("MacBook Air")) {
            System.out.println("Product 2 Text is displayed correctly");
        }
        else {
            System.out.println("Product 2 Text is not displayed correctly");
        }
        if(product2_text.equals("MacBook Pro")) {
            System.out.println("Product 2 Text is displayed correctly");
        }
        else {
            System.out.println("Product 2 Text is not displayed correctly");
        }


        String TotalAmount = driver.findElement(By.xpath("(//table[@class='table table-bordered'])[3]//tr[2]")).getText();
        if(TotalAmount.equals("$3,000,00")){
            System.out.println("Total amount is correct")
        }else {
            System.out.println("Totral amount is not correct");
        }
        driver.findElement(By.xpath("//a[text()='Checkout']")).click();
        driver.quit();

    }
}