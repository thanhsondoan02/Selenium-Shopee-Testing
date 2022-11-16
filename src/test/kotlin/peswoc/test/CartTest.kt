package peswoc.test

import org.testng.annotations.Test
import peswoc.base.BaseTest
import peswoc.page.CartPage
import peswoc.page.LoginPage
import peswoc.page.ProductPage

class CartTest : BaseTest<ProductPage>() {

    override val page: ProductPage
        get() = ProductPage()

    private val cartPage: CartPage
        get() = CartPage()

    private val loginPage: LoginPage
        get() = LoginPage()

    init {
        holdBrowserOpen = true
    }

    @Test
    fun addToCart(){
        Thread.sleep(2000)

        // if haven't logged then login
        if (loginPage.accountNav.size == 0) {
            loginPage.open()
            wait.until{ loginPage.emailBoxes.size == 1 }
            loginPage.login(wait)
        }

        //open product page and get title of product
        page.open()
        val title = page.title.text()

        // open cart page and check if the product exists
        cartPage.open()
        Thread.sleep(2000)
        val oldProductNumber = getProductNumberOfTitle(title)

        // add product to cart
        page.open()
        page.chooseAllType(wait)
        page.addToCartButton.click()

        // check if the product is added to cart
        cartPage.open()
        Thread.sleep(2000)
        assert(getProductNumberOfTitle(title) == oldProductNumber + 1)
    }

    @Test
    fun deleteFromCart() {
        Thread.sleep(2000)

        // if haven't logged then login
        if (loginPage.accountNav.size == 0) {
            loginPage.open()
            wait.until{ loginPage.emailBoxes.size == 1 }
            loginPage.login(wait)
        }

        // open cart page and get first product title
        cartPage.open()
        Thread.sleep(2000)
        val title = cartPage.productTitleList[0]

        // delete product with that title
        cartPage.deleteButtonList[cartPage.productTitleList.indexOf(title)].click()

        // check if the product is deleted
        wait.until{ !cartPage.productTitleList.contains(title) }
    }

    private fun getProductNumberOfTitle(title: String): Int {
        val titleList = cartPage.productTitleList
        val numberList = cartPage.getProductNumberList()
        return if (titleList.isNotEmpty() && titleList.contains(title)) {
            numberList[titleList.indexOf(title)]
        } else {
            0
        }
    }

}

