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

    override fun loadPage() {}

    @Test
    fun addToCart(){
        // login to existing account
        loginPage.open()
        loginPage.login(wait)

        //open product page and get title of product
        page.open()
        val title = page.title.text()
        var oldProductNumber = 0

        // open cart page and check if the product exists
        cartPage.open()
        Thread.sleep(2000)
        oldProductNumber = getProductNumberOfTitle(title)

        // add product to cart
        page.open()
        page.chooseAllType(wait)
        page.addToCartButton.click()

        // check if the product is added to cart
        cartPage.open()
        Thread.sleep(2000)
        assert(getProductNumberOfTitle(title) == oldProductNumber + 1)
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

