package com.patrickgross.pageobjects

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class CartPage(private val driver : WebDriver) {


    @FindBy(id = "huc-v2-order-row-messages")
    private val addedToCart: WebElement? = null

    @FindBy(className = "hlb-checkout-button")
    private val checkoutButton: WebElement? = null

    init {

        PageFactory.initElements(driver, this)
    }

    fun checkIfAddedToCart() : Boolean{

        return addedToCart?.text.equals("Added to Cart")
    }

    fun checkout() {

        checkoutButton?.click()
    }
}