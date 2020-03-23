package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions
		(
		features= "./Features/searchKeyWord.feature",
		glue= "steps",
		dryRun= false,
		plugin= {"pretty"}
		)
@RunWith(Cucumber.class)
public class RunnerClass {

}
