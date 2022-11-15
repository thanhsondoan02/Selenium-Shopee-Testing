package peswoc.test

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.WebDriverRunner
import org.openqa.selenium.support.ui.ExpectedConditions.urlToBe
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import peswoc.base.BaseTest
import peswoc.page.LoginPage

class LoginTest : BaseTest<LoginPage>() {

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
        page.buttonLogin.shouldBe(disabled)
        page.emailBox.sendKeys("fvasfgsa")
        page.passwordBox.sendKeys("fasgfags")
        page.buttonLogin.shouldBe(enabled)
    }

    @Test
    fun wrongEmailOrPassword() {
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