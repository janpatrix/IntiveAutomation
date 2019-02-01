package com.patrickgross.stepDefinitions

import com.patrickgross.pageobjects.CartPage
import com.patrickgross.pageobjects.DetailsPage
import com.patrickgross.pageobjects.LandingPage
import com.patrickgross.pageobjects.ResultsPage
import com.patrickgross.testUtils.DriverSetup
import cucumber.api.Scenario
import cucumber.api.java8.En
import org.junit.Assert
import kotlin.test.assertEquals
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebElement
import gherkin.deps.com.google.gson.annotations.Until
import java.sql.Time


class AmazonSweetSearch: DriverSetup(), En {

    private var landingPage: LandingPage? = null
    private var resultsPage: ResultsPage? = null
    private var detailsPage: DetailsPage? = null
    private var cartPage: CartPage? = null

    init {

        Given("^I open (\\S+)$") { url: String ->

            driverSetup(url)
            landingPage = LandingPage(driver)
            resultsPage = ResultsPage(driver)
            detailsPage = DetailsPage(driver)
            cartPage = CartPage(driver)

            assertEquals(driver.currentUrl, "https://www.amazon.com/")
        }

        Then("^I search for (\\S+)$") {product: String ->

            landingPage?.searchProduct(product)
            Assert.assertTrue(resultsPage!!.isPageOpened(product))
        }

        Then("^I sort by \"([^\"]*)\"$") { sortBy: String ->

            resultsPage?.sortResults(sortBy)
            Assert.assertTrue(resultsPage!!.isPageOpened("price-asc-rank"))
        }

        Then("^I pick the first item in the list$") {

            Thread.sleep(1000)
            val cheapestItem : String? = resultsPage?.selectItemInList()
            val productTitle : String? = detailsPage?.returnProductTitle()
            Assert.assertEquals(cheapestItem, productTitle)
        }

        Then("^I add it to the cart$") {

            detailsPage?.addToCart()
            Assert.assertTrue(cartPage!!.checkIfAddedToCart())

        }

        After { scenario: Scenario? ->

            driverClose()
        }
    }
}