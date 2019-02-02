package com.patrickgross.testUtils

import com.patrickgross.utils.PageProperties
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.net.URI
import java.util.concurrent.TimeUnit
import org.openqa.selenium.firefox.FirefoxDriver



abstract class DriverSetup{

    lateinit var driver: WebDriver
    private set

    fun driverSetup(url: String) {

        var browserName: String = System.getProperty("browser")

        var nameDriver: String = PageProperties.getProperties(browserName + "NameDriver")
        var pathDriver: String = PageProperties.getProperties(browserName + "PathDriver")
        var exeDriver: String = PageProperties.getProperties(browserName + "ExeDriver")

        System.setProperty(nameDriver, pathDriver + exeDriver)

        when (PageProperties.getProperties(browserName + "NameDriver")) {
            "webdriver.gecko.driver" -> driver = FirefoxDriver()
            "webdriver.chrome.driver" -> driver = ChromeDriver()
            else -> throw RuntimeException("Unsupported webdriver: $driver")
        }

        driver?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver?.manage()?.window()?.maximize()
        driver.get(URI(url).toString())
    }

    fun driverClose(){

        driver?.quit()
    }
}