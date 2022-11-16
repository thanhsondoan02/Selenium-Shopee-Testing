package peswoc.page

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import peswoc.base.IBasePage

class LoginPage : IBasePage {

    companion object {
        const val PAGE_URL = "https://shopee.vn/buyer/login"
        const val LOGIN_SUCCESS_URL = "https://shopee.vn/?is_from_login=true"
        const val EMAIL_BOX = "//input[@name='loginKey']"
        const val PASSWORD_BOX = "//input[@name='password']"
        const val BUTTON_LOGIN = "/html/body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form/div[1]/div[2]/button"
        const val LOGIN_ALERT = "//div[@class='gCY-Ye']"
    }

    val emailBox = element(byXpath(EMAIL_BOX))
    val emailBoxes = Selenide.elements(byXpath(EMAIL_BOX))
    val passwordBox = element(byXpath(PASSWORD_BOX))
    val buttonLogin = element(byXpath(BUTTON_LOGIN))
    val loginAlert = element(byXpath(LOGIN_ALERT))
    val accountNav = Selenide.elements(byXpath(ProductPage.ACCOUNT_NAV))

    override fun open() {
        open(PAGE_URL)
    }

    fun login(wait: WebDriverWait, accountEmail: String = "bihepimaidarl7@gmail.com", accountPassword: String = "Abcd1234") {
        emailBox.sendKeys(accountEmail)
        passwordBox.sendKeys(accountPassword)
        buttonLogin.shouldBe(Condition.enabled).click()
//        wait.until{ Selenide.elements(byXpath(ProductPage.ACCOUNT_NAV)).size == 1 }
        wait.until{ accountNav.size == 1 }
    }

    fun waitUtilLoginPage(wait: WebDriverWait): LoginPage {
        wait.until(ExpectedConditions.urlContains(PAGE_URL))
        return this
    }

}