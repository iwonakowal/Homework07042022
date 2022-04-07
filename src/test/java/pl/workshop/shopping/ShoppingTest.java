package pl.workshop.shopping;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/mystore/shopping.feature", plugin = {"pretty","html:target/shopping-report.html"})
public class ShoppingTest {
}
