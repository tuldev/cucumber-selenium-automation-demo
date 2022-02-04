package com.ptl.localhut.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver webDriver;

    By email = By.name("email");
    By password = By.name("password");
    By submit = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("http://dev.localhut.co.uk");
        try {
            Thread.sleep(2000);  // Let the user actually see something!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("//a[@href='http://dev.localhut.co.uk/login']")).click();
    }

    public HomePage loginWithValidUser(String email, String password) {
        webDriver.findElement(this.email).sendKeys(email);
        webDriver.findElement(this.password).sendKeys(password);
        webDriver.findElement(this.submit).click();
        return new HomePage(webDriver);
    }
}
