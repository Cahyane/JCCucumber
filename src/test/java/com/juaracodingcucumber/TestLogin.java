package com.juaracodingcucumber;

import com.juaracodingcucumber.drivers.DriverSingleton;
import com.juaracodingcucumber.pages.LoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {
    public static WebDriver driver;
    public static LoginPage loginPage;
    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
    }
    @Given("User open browser and url")
    public void user_open_browser_url(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("User open browser and url");
    }
    @When("User enter valid username")
    public void user_enter_valid_username() {
        loginPage.enterUsername("Admin");
        System.out.println("User enter valid username");
    }

    @And("User enter valid password")
    public void user_enter_valid_password() {
        loginPage.enterPassword("admin123");
        System.out.println("User enter valid password");
    }

    @And("User click button login")
    public void user_click_button_login() {
        loginPage.buttonLogin();
        System.out.println("User click button login");
    }

    @Then("User go to page Dashboard")
    public void user_go_to_page_Dashboard() {
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
        System.out.println("User go to page Dashboard");
    }

    @When("User click button logout")
    public void user_click_button_logout(){
        loginPage.buttonMenu();
        loginPage.buttonLogout();
        System.out.println("User click button logout");
    }

    @And("User enter invalid username")
    public void user_enter_invalid_username(){
        loginPage.enterUsername("Adminn");
        System.out.println("User enter invalid username");
    }
    @And("User enter invalid password")
    public void user_enter_invalid_password() {
        loginPage.enterPassword ("Cobacoba123");
        System.out.println("User enter invalid password");
    }

    @Then("User get message invalid credentials")
    public void User_get_message_invalid_credentials (){

    }

    @When("User enter invalid username login")
    public void user_enter_invalid_username_login(){
        loginPage.enterUsername("Widya");
        System.out.println("User enter invalid username login");}

    @And ("User enter empty password")
    public void user_enter_empty_password(){
        loginPage.enterPassword("");
        System.out.println("User enter empty password");}

    @AfterAll
    public static void quitBrowser(){
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


