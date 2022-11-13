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
            loginPage.waitUtilLoginPage(wait).login(accountEmail, accountPassword)
            wait.until(ExpectedConditions.urlToBe(page.pageUrl + "&is_from_login=true"))
            page.accountNav.shouldBe(Condition.visible)
        }
        chooseItemAndClickAddCart(addValue)

        // check in page cart
    }

    fun chooseItemAndClickAddCart(valueList: List<Int>) {
        for (i in 0..valueList.size - 2) {
            page.flexItem(i+1, addValue[i]).click()
        }
        changeQuantity(addValue.last())
        page.addToCartButton.click()
    }



    fun changeQuantity(expectedQuantity: Int) {
        while (page.quantityInput.value!!.toInt() != expectedQuantity) {
            if (page.quantityInput.value!!.toInt() < expectedQuantity) {
                page.quantityPlusButton.click()
            } else {
                page.quantityMinusButton.click()
            }
        }
    }

}