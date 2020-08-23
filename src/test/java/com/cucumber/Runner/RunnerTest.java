package com.cucumber.Runner;

import Cucumber_Listener.ExtentProperties;
import Cucumber_Listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\HP\\Documents\\Optimum Assessment\\src\\test\\resources\\FeatureFiles\\UserStoryTwoContactDetails.feature"},
        glue = {"com/cucumber/StepDefinitions"},
        monochrome = true,
        //plugin = {"pretty","html:target/HtmlReports"}
        plugin = {"Cucumber_Listener.ExtentCucumberFormatter:"}
)
public class RunnerTest {

    @BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
//        extentProperties.setExtentXServerUrl("http://localhost:1337");
//        extentProperties.setProjectName("MyProject");
      //  extentProperties.setReportPath("output/myreport.html");
    }

    @AfterClass
    public static void teardown() {
        //Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");

    }
}

