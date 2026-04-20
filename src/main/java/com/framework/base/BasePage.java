package com.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locater){
        wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
    }

    public void type(By locater, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).sendKeys(text);
    }

    public String getText(By locater){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).getText();
    }

    public boolean isDisplayed(By locater){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).isDisplayed();
    }


}
