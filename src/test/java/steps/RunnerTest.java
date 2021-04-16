package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/features",
        glue={"steps"},
        plugin={"pretty",
                "html:target/htmlReport/cucumberHtmlReport.html",
                "json:target/jsonReports/cucumber-report.json"
        }
//		plugin="json:target/jsonReports/cucumber-report.json"
//		tags="not @ignore"
)
public class RunnerTest  {

}
