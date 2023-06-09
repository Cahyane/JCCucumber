package com.juaracodingcucumber.pages;

import com.juaracodingcucumber.drivers.DriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement txtDashboard;
    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    WebElement loginTitle;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement txtInvalidCredentials;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement btnMenu;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement btnLogout;

    public String getLoginTitle() {
        return loginTitle.getText();
    }
    public String getTxtDashboard() {
        return txtDashboard.getText();}
    public String getTxtInvalidCredentials() {
        return txtInvalidCredentials.getText();
    }
    public void enterUsername(String username) {
        this.username.sendKeys(username);}
    public void enterPassword(String password) {
        this.password.sendKeys(password);}
    public void buttonLogin() { btnLogin.click();}
    public void buttonLogout() { btnLogout.click();}
    public void buttonMenu() { btnMenu.click();}
    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }
}


