package peswoc.test

import com.codeborne.selenide.WebDriverRunner
import org.testng.annotations.Test
import peswoc.base.BaseTest
import peswoc.page.CartPage
import peswoc.page.LoginPage
import peswoc.page.ProductPage

class OrderTest : BaseTest<LoginPage>() {

    companion object {
        const val ORDER_SUCCESSFUL_URL = "https://shopee.vn/checkout"
    }

    override val page: LoginPage
        get() = LoginPage()

    private val productPage: ProductPage
        get() = ProductPage()

    private val cartPage: CartPage
        get() = CartPage()

    @Test
    fun orderFromCart() {
        page.login(wait)

        productPage.open()
        productPage.addToCart(wait)

        cartPage.open()
        Thread.sleep(2000)
        cartPage.tickFirstProduct()


        wait.until {cartPage.labelCheckBoxes.size == 2 }

        cartPage.orderButton.click()
        Thread.sleep(2000)

        if (!WebDriverRunner.currentFrameUrl().contains(ORDER_SUCCESSFUL_URL)) {
            assert(cartPage.alertCloseButton.isDisplayed)
        }
    }

    @Test
    fun cancelOrder() {
        page.login(wait)

        productPage.open()
        val title = productPage.title.text()
        productPage.addToCart(wait)

        cartPage.open()
        Thread.sleep(2000)
        cartPage.tickFirstProduct()

        wait.until {cartPage.labelCheckBoxes.size == 2 }

        cartPage.orderButton.click()
        Thread.sleep(2000)

        if (!WebDriverRunner.currentFrameUrl().contains(ORDER_SUCCESSFUL_URL)) {
            assert(cartPage.alertCloseButton.isDisplayed)

            cartPage.alertCloseButton.click()
            Thread.sleep(2000)

            cartPage.deleteButtonList[0].click()
            wait.until { !cartPage.productTitleList.contains(title) }
        }
    }

}