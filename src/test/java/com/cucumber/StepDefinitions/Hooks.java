package com.cucumber.StepDefinitions;

import Utilities.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;

public class Hooks {

    Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void initializeDriver (){
        DriverFactory.getInstance().initializeDriver();
    }

    @After
    public void quitDriver(){
        DriverFactory.getInstance().getDriver().quit();
    }
}
