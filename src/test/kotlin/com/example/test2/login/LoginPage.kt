package com.example.test2.login

import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import com.example.test2.base.BasePage

class LoginPage : BasePage {

    companion object {
        const val PAGE_URL = "https://shopee.vn/buyer/login"
        const val LOGIN_SUCCESS_URL = "https://shopee.vn/?is_from_login=true"
        const val EMAIL_BOX = "//input[@name='loginKey']"
        const val PASSWORD_BOX = "//input[@name='password']"
        const val BUTTON_LOGIN = "/html/body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form/div[1]/div[2]/button"
        const val LOGIN_ALERT = "//div[@class='gCY-Ye']"
    }

    val emailBox = element(byXpath(EMAIL_BOX))
    val passwordBox = element(byXpath(PASSWORD_BOX))
    val buttonLogin = element(byXpath(BUTTON_LOGIN))
    val loginAlert = element(byXpath(LOGIN_ALERT))

    override fun open() {
        open(PAGE_URL)
    }

}