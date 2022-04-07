package pl.workshop.address;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/mystore/address.feature", plugin = {"pretty","html:target/address-report.html"})
public class AddAddressTest {
}
