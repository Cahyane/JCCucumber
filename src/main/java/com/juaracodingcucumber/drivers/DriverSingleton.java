package com.juaracodingcucumber.drivers;


import com.juaracodingcucumber.drivers.strategies.DriverStrategy;
import com.juaracodingcucumber.drivers.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

    public class DriverSingleton {
        private static com.juaracodingcucumber.drivers.DriverSingleton instance = null;
        private static WebDriver driver;

        private DriverSingleton(String driver) {
            instantiate(driver);
        }

        public WebDriver instantiate(String strategy) {

            DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
            driver = driverStrategy.setStrategy();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        }

        public static DriverSingleton getInstance(String driver) {
            if (instance == null) {
                instance = new DriverSingleton(driver);
            }
            return instance;
        }

        public static WebDriver getDriver() {
            return driver;
        }

        public static void closeObjectInstance() {
            instance = null;
            driver.quit();
        }
    }

