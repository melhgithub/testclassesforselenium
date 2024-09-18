package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/resources/features/contactus.feature", 
	    glue = "stepDefinition", 
	    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"}
	)


public class TestRunner1 extends AbstractTestNGCucumberTests {

}
