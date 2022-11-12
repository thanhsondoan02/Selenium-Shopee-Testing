package com.example.test2.model

import com.codeborne.selenide.Condition.attribute
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.testng.Assert.assertEquals
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class MainPageTest {
    private val mainPage = MainPage()

    companion object {
        @BeforeClass
        fun setUpAll() {
            Configuration.browserSize = "1280x800"
            SelenideLogger.addListener("allure", AllureSelenide())
        }
    }

    @BeforeMethod
    fun setUp() {
//        open("https://www.jetbrains.com/")
        mainPage.open()
    }

    @Test
    fun search() {
        mainPage.searchButton.click()

        element("[data-test='search-input']").sendKeys("Selenium")
        element("button[data-test='full-search-button']").click()

        element("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"))
    }

    @Test
    fun toolsMenu() {
        mainPage.toolsMenu.click()

        element("div[data-test='main-submenu']").shouldBe(visible)
    }

    @Test
    fun navigationToAllTools() {
        mainPage.seeAllToolsButton.click()

        element("#products-page").shouldBe(visible)

        assertEquals(Selenide.title(), "All Developer Tools and Products by JetBrains")
    }
}
