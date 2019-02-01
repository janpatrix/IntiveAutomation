import com.patrickgross.pageobjects.CartPage
import com.patrickgross.pageobjects.LandingPage
import com.patrickgross.pageobjects.ResultsPage
import com.patrickgross.testUtils.DriverSetup
import cucumber.api.Scenario
import cucumber.api.java8.En
import org.junit.Assert
import kotlin.test.assertEquals


class AmazonSweetSearch: DriverSetup(), En {

    private var landingPage: LandingPage? = null
    private var resultsPage: ResultsPage? = null
    private var cartPage: CartPage? = null

    init {

        Given("^I open (\\S+)$") { url: String ->

            driverSetup(url)
            landingPage = LandingPage(driver)
            resultsPage = ResultsPage(driver)
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
            resultsPage?.selectItemInList()
            //detailsPage?.addToCart()
            Assert.assertTrue(cartPage!!.checkIfAddedToCart())
        }

        Then("^I checkout") {

            cartPage?.checkout()
            Assert.assertTrue(driver?.currentUrl.contains("signin"))
        }

        After { scenario: Scenario? ->

            driverClose()
        }
    }
}