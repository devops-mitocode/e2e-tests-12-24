package com.mycompany;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty" },
        features = "src/test/resources/features",
        glue = { "com.mycompany.steps" },
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class End2EndTests {
}
