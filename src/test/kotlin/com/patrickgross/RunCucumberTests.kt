package com.patrickgross

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["."],
    tags = ["@amazon"])

class RunCucumberTests