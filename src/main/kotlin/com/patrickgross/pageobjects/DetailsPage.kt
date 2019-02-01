package com.patrickgross.pageobjects

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class DetailsPage(private val driver : WebDriver) {


    @FindBy(id = "productTitle")
    private val productTitle: WebElement? = null

    @FindBy(id = "add-to-cart-button")
    private val cartButton: WebElement? = null

    init {

        PageFactory.initElements(driver, this)
    }

    fun returnProductTitle() : String{

        return productTitle!!.text
    }

    fun addToCart() {

        cartButton?.click()
    }

}
