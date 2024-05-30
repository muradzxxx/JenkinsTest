package org.example.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CucSelenium {

//    private WebDriver driver;
//
//
    private WebDriverWait wait;
    private LoginPage loginPage;
    private final WebDriver driver;


    public CucSelenium()  {
        driver = Hooks.driver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }


    @Given("User enters url")
    public void user_enters_url() {
        loginPage.logintoSite();
//        driver.findElement(By.linkText("Log in")).click();

    }

    @And("He enters userName")
    public void he_enters_userName() {
// Write code here that turns the phrase above into concrete actions

        driver.findElement(By.id("Email")).sendKeys("vishnu@vmail.com");
    }

    @When("He enters password")
    public void he_enters_password() {
// Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("Password")).sendKeys("123456");

    }

    @Then("Home page is displayed")
    public void home_page_is_displayed() {
// Write code here that turns the phrase above into concrete actions

        System.out.println("home page");

//driver.findElement(By.xpath("//*[@value='Log in'])")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();

    }

}
