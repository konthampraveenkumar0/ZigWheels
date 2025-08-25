package com.zigwheels.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"com.zigwheels.stepDefinations"},
    plugin = {"pretty",
    		"html:target/cucumber-reports.html",
    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    		
    },
    dryRun=false,
    publish=true,
    monochrome = true
)
public class TestRunner
{
	
}
