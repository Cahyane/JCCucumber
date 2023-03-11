package com.juaracodingcucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/main/resources/features/Login.feature",
        glue = { "com.juaracodingcucumber"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
