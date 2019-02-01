package com.patrickgross.testUtils

import com.patrickgross.utils.PageProperties
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.net.URI
import java.util.concurrent.TimeUnit

abstract class DriverSetup{

    lateinit var driver: WebDriver
    private set

    fun driverSetup(url: String) {

        System.setProperty(PageProperties.getProperties("nameDriver"),
            PageProperties.getProperties("pathDriver") + PageProperties.getProperties("exeDriver"))
        driver = ChromeDriver()
        driver?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        val maximize = driver?.manage()?.window()?.maximize()
        driver.get(URI(url).toString())
    }

    fun driverClose(){

        driver?.quit()
    }
}