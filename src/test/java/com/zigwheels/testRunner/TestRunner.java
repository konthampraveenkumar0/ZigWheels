package com.zigwheels.testRunner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.zigwheels.utilities.AllureReportOpener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;


//@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/Features"
    		
    },
    glue = {"com.zigwheels.stepDefinations"},
    plugin = {"pretty",
    		"html:target/cucumber-reports.html",
    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    		
    		
    }, 
    dryRun=false,
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests
{
	@BeforeSuite
	public void beforeSuite() {
		AllureReportOpener.cleanAllureResults();
	}
	
	@AfterSuite
	public void afterSuite() {
		AllureReportOpener.openAllureReport();
	}
}
