package Test_Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
          features = {"src/test/java/Feature/Dominos.feature"},
          glue = {"Step_Definition"},
          dryRun = !true,
          snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner_Class {
}
