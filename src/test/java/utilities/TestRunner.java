package utilities;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = "org.example.stepdefs",
        tags = "",
        plugin = {"rerun:target/failedrerun.txt", "pretty", "json:target/Cucumber.json"}
)
public class TestRunner {
}
