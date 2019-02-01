package com.patrickgross.utils

import java.io.FileInputStream
import java.io.IOException
import java.util.*

object PageProperties {

    private var properties: Properties? = null

    fun loadProperties(): Unit{
        try{
            properties = Properties()
            properties?.load(FileInputStream("config.properties"))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getProperties(properties: String): String {
        loadProperties()
        return PageProperties.properties?.getProperty(properties).toString()
    }
}
