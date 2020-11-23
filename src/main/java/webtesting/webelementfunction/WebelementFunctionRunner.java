package webtesting.webelementfunction;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/Web/Login/WebelementFunction.feature"},
		glue = {"webtesting.webelementfunction","webtesting.generichook"},
		dryRun = false,
		monochrome = true
		)
public class WebelementFunctionRunner extends AbstractTestNGCucumberTests {

}
