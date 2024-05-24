package org.example.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CucSelenium {

    WebDriver driver;
    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Murad\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArgument--headless");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--window-size=1024,768");
//        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(chromeOptions);
//        getDriver().manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.manage().window().maximize();
    }
    @Given("User enters url")
    public void user_enters_url() {
        driver.get("http://demowebshop.tricentis.com/");
        driver.findElement(By.linkText("Log in")).click();

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
