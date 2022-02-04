package com.ptl.localhut;

import com.ptl.localhut.pageObject.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver = null;
    LoginPage loginPage = null;

    @Before
    public void openSession(){
        System.out.println("The precondition executed successfully ");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver"); // download, install and set path (provide permission on security mac level)
        driver = new ChromeDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage = new LoginPage(driver);
    }

    @When("I login with email as (.*) and password as (.*)")
    public void i_login_with_email_and_password(String email, String password) {
       loginPage.loginWithValidUser(email, password);
    }

    @Then("I should see a flash message saying You logged into a secure area!")
    public void i_should_see_a_flash_message_saying_You_logged_into_a_secure_area() {
    }

    @After
    public void closeSession(){
        System.out.println("The postcondition executed successfully ");
        driver.quit();
    }

}
