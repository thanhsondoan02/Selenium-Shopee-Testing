package com.example.test2.home

import com.codeborne.selenide.Configuration
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class HomePageTest {

    private val homePage = HomePage()

    companion object {

        @BeforeClass
        fun setUpAll() {
//            Configuration.browserSize = "1920x1080"
        }

    }

    @BeforeMethod
    fun setUp() {
        homePage.open()
    }

    @AfterMethod
    fun setHoldBrowserOpen() {
        Configuration.holdBrowserOpen = true
    }

    @Test
    fun search() {
//        homePage.popUpCloseButton.click()
        homePage.searchBox.click()
        homePage.searchBox.sendKeys("Selenium")
//        homePage.searchButton.click()
//        Configuration.holdBrowserOpen = true
    }

}