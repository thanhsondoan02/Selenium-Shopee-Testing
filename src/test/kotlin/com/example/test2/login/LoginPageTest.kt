package com.example.test2.login

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.WebDriverRunner
import com.example.test2.base.BaseTest
import org.openqa.selenium.support.ui.ExpectedConditions.urlToBe
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class LoginPageTest : BaseTest<LoginPage>() {

    override val page: LoginPage
        get() = LoginPage()

    @BeforeMethod
    override fun beforeMethod() {
        WebDriverRunner.closeWebDriver()
        super.beforeMethod()
    }

    @Test
    fun emptyEmail() {
        page.emailBox.sendKeys("")
        page.passwordBox.sendKeys("rsaffas")
        page.buttonLogin.shouldBe(disabled)
    }

    @Test
    fun emptyPassword() {
        page.emailBox.sendKeys("faskf")
        page.passwordBox.sendKeys("")
        page.buttonLogin.shouldBe(disabled)
    }

    @Test
    fun filledEmailAndPassword() {
        page.emailBox.sendKeys("fvasfgsa")
        page.passwordBox.sendKeys("fasgfags")
        page.buttonLogin.shouldBe(enabled)
    }

    @Test
    fun wrongEmailAndPassword() {
        page.emailBox.sendKeys("bihepimaidarl7@gmail.com")
        page.passwordBox.sendKeys("Abcd12345")
        page.buttonLogin.shouldBe(enabled).click()
        page.loginAlert.shouldBe(visible)
    }

    @Test
    fun correctEmailAndPassword() {
        page.emailBox.sendKeys("bihepimaidarl7@gmail.com")
        page.passwordBox.sendKeys("Abcd1234")
        page.buttonLogin.shouldBe(enabled).click()
        wait.until(urlToBe(LoginPage.LOGIN_SUCCESS_URL))
    }

}