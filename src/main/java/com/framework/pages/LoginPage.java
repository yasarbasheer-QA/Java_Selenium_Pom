package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By button = By.id("login-button");

   public LoginPage(WebDriver driver){
       super(driver);
   }

   public void enterUsername(String username){ type(usernameField,username); }
    public void enterPassword(String password){
        type(passwordField,password);
    }
    public void clickLoginButton(){
       click(button);
    }

    public void login(String username, String password){
       enterUsername(username);
       enterPassword(password);
       clickLoginButton();
    }

}
