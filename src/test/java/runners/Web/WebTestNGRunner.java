package runners.Web;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features={"src/test/resources/features"},
        glue= {"steps", "hooks"},
        monochrome=true,
        dryRun = false,
        plugin={"html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        )

public class WebTestNGRunner extends AbstractTestNGCucumberTests {
}
