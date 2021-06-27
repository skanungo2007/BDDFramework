package com.qa.runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions( 
		
		features = ".\\src\\test\\java\\com\\qa\\features",
		glue = {"com.qa.stepDefinition"},
		format = {"pretty", "html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json", "junit:target/cucumber-reports/CucumberTestxmlReport.xml"},
		plugin = "json:target/cucumber-reports/CucumberTestReport.json",
		monochrome = true,
		tags = {"@Smoke"}
		
		)

public class RunnerClass {
	
	
	private TestNGCucumberRunner testNGCucumberRunner;
	
	
	@BeforeClass(alwaysRun=true)
	public void setupClass() {
		
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());	
		
	}
	
	
	@Test(description="Cucumber Feature", dataProvider="getFeatures")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		
	}

	
	@DataProvider
	public Object[][] getFeatures() {
		
		return testNGCucumberRunner.provideFeatures();
		
	}
	
	
	@AfterClass(alwaysRun=true)
	public void tearDownClass() {
		
		testNGCucumberRunner.finish();
		
	}
}
