package peswoc.test

import com.codeborne.selenide.Condition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.annotations.Test
import peswoc.base.BaseTest
import peswoc.page.LoginPage
import peswoc.page.ProductPage

class OrderTest : BaseTest<ProductPage>() {

    override val page = ProductPage()
    val loginPage= LoginPage()

    init {
        holdBrowserOpen = true
    }

    var plusClick = 4
    var minusClick = 1

    @Test
    fun test1IncreasingQuantity() {
        var expectedQuantity = page.quantityInput.value!!.toInt()
        for (i in 1..plusClick) {
            page.quantityPlusButton.click()
            expectedQuantity++
            wait.until(ExpectedConditions.textToBePresentInElementValue(page.quantityInput, expectedQuantity.toString()))
        }
    }

    @Test
    fun test2DecreasingQuantity() {
        var expectedQuantity = page.quantityInput.value!!.toInt()
        for (i in 1..plusClick) {
            page.quantityPlusButton.click()
            expectedQuantity++
            wait.until(ExpectedConditions.textToBePresentInElementValue(page.quantityInput, expectedQuantity.toString()))
        }
        for (i in 1..minusClick) {
            page.quantityMinusButton.click()
            if (expectedQuantity > 1) expectedQuantity--
            wait.until(ExpectedConditions.textToBePresentInElementValue(page.quantityInput, expectedQuantity.toString()))
        }
    }


    val addValue = arrayListOf(1, 2)
    var accountEmail = "bihepimaidarl7@gmail.com"
    var accountPassword = "Abcd1234"

    @Test
    fun loginAndAddToCart() {
        if (page.accountNavList.size == 0) { // not login yet
            page.addToCartButton.click()
            loginPage.waitUtilLoginPage(wait).login(wait, accountEmail, accountPassword)
            wait.until(ExpectedConditions.urlToBe(LoginPage.PAGE_URL + "&is_from_login=true"))
            page.accountNav.shouldBe(Condition.visible)
        }
        page.chooseItemAndClickAddCart()

        // check in page cart
    }







}