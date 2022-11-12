package com.example.test2.base

import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod

interface IBaseTest {

    val page: BasePage
    val wait: WebDriverWait
    var waitSecond: Long

    @BeforeClass
    fun beforeClass()

    @BeforeMethod
    fun beforeMethod()

    @AfterMethod
    fun afterMethod()

    fun deleteCache()

    fun loadPage()

}