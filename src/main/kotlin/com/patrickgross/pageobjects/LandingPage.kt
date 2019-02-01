package com.patrickgross.pageobjects

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LandingPage(private val driver : WebDriver) {

    @FindBy(id = "twotabsearchtextbox")
    private val searchBox: WebElement? = null

    init {

        PageFactory.initElements(driver, this)
    }

    fun searchProduct(product: String){

        searchBox?.sendKeys(product)
        searchBox?.sendKeys(Keys.ENTER)
    }
}