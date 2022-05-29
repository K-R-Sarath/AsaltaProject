package testRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.sorting.SortingMethod;

@RunWith(Cucumber.class)
@CucumberOptions
				(
				publish=true,		
				features="src/test/resources/Features",
				glue="stepDefinitions",
				dryRun=false,
				plugin={"json:target/cucumber-report/cucumber.json","de.monochromata.cucumber.report.PrettyReports:target/cucumber","rerun:target/rerun.txt"},
				tags = "@Test",
				monochrome=true
				)

public class TestRunner {
	
	@SuppressWarnings("unchecked")
	@AfterClass
	public static void tearDown() {
		
		File reportOutputDirectory = new File("target/cucumber");
		List jsonFiles = new ArrayList<>();
		jsonFiles.add("target/cucumber-report/cucumber.json");
		
		Configuration config = new Configuration(reportOutputDirectory, "Asalta-Inventory");
		config.addClassifications("Environment", "Local");
		config.addClassifications("Browser", "Firefox");
		config.addClassifications("Platform", System.getProperty("os.name").toUpperCase());
		config.setSortingMethod(SortingMethod.NATURAL);
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
		reportBuilder.generateReports();
	}

}
