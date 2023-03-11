package com.juaracodingcucumber.pages;


import com.juaracodingcucumber.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

        private WebDriver driver;
        public RecruitmentPage(){
            this.driver = DriverSingleton.getDriver();
            PageFactory.initElements(driver, this);
        }
    }
