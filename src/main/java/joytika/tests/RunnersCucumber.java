package joytika.tests;


import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"pretty", "html:target/cucumber"}
       )

public class RunnersCucumber {
}
