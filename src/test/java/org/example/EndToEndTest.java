package org.example;

import cucumber.runtime.SerenityObjectFactory;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(CucumberWithSerenity.class)
@CucumberContextConfiguration
@CucumberOptions(
        objectFactory = SerenityObjectFactory.class ,
        plugin = {"pretty", "json:target/cucumber.json"},
        features = "classpath:features"
)
@SpringBootTest
public class EndToEndTest {

}
