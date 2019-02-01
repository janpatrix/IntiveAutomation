package com.patrickgross.pageobjects

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.Select

class ResultsPage(private val driver: WebDriver) {

    @FindBy(id = "sort")
    private val sortDropDown: WebElement? = null

    init {

        PageFactory.initElements(driver, this)
    }

    fun isPageOpened(suffix: String) : Boolean {

        return (driver.currentUrl.endsWith(suffix))
    }

    fun sortResults(sortBy: String) {

        val dropBox = Select(sortDropDown)
        dropBox.selectByVisibleText(sortBy)
    }

    fun selectItemInList() {

        val item: WebElement? = driver.findElement(By.className("a-button-input"))
        item!!.click()
    }
}