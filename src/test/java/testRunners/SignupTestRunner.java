package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/features/signup.feature"},
        glue = {"stepDefinitions"},
        plugin = { "progress" },
        monochrome = true
)

public class SignupTestRunner {}