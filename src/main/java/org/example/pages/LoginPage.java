package org.example.pages;

import org.example.utils.BaseDriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseDriverClass {


    @FindBy(linkText = "Log in")
    private WebElement login;



    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void logintoSite() {
        login.click();

    }
}
