package com.patrickgross.stepDefinitions

import com.patrickgross.testUtils.DriverSetup
import cucumber.api.PendingException
import cucumber.api.java8.En

class AmazonSweetSearch: DriverSetup(), En {
    init {

        Given("^I open https://www\\.amazon\\.com$") {
            // Write code here that turns the phrase above into concrete actions
            throw PendingException()
        }

        Then("^I search for Snickers$") {
            // Write code here that turns the phrase above into concrete actions
            throw PendingException()
        }

        Then("^I sort by \"([^\"]*)\"$") { arg1: String ->
            // Write code here that turns the phrase above into concrete actions
            throw PendingException()
        }

        Then("^I pick item number (\\d+) in the list$") { arg1: Int ->
            // Write code here that turns the phrase above into concrete actions
            throw PendingException()
        }
    }
}