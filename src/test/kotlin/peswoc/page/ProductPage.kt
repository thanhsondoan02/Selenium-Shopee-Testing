package peswoc.page

import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import peswoc.base.IBasePage

class ProductPage: IBasePage {

    companion object {
        const val QUANTITY_PLUS = "//div[@class='_1RTqoK shopee-input-quantity']/button[2]"
        const val QUANTITY_MINUS = "//div[@class='_1RTqoK shopee-input-quantity']/button[1]"
        const val QUANTITY_INPUT = "//div[@class='_1RTqoK shopee-input-quantity']/input[1]"
        const val ADD_TO_CART_BUTTON = "//div[@class='_37uIr4']/button[1]"
        const val BUY_NOW_BUTTON = "//div[@class='_37uIr4']/button[2]"
        const val CART_SIZE_LABEL = "//div[@class='shopee-cart-number-badge']"
        const val FLEX_GROUP = "//div[@class='flex flex-column']/"
        const val ACCOUNT_NAV = "//li[@class='navbar__link navbar__link--tappable navbar__link--hoverable navbar__link--account']"
    }

    var pageUrl: String = "https://shopee.vn/Qu%E1%BA%A7n-Jean-Nam-Anyoung-Qu%E1%BA%A7n-Baggy-Nam-%E1%BB%90ng-R%E1%BB%99ng-M%C3%A0u-Kem-D%C3%A1ng-Xu%C3%B4ng-Form-Chu%E1%BA%A9n-H%C3%A0n-Qu%E1%BB%91c-Qd18-i.396434623.9077465739?sp_atk=65cb33a2-ada0-4daa-bcaf-1c6bb87b63d1&xptdk=65cb33a2-ada0-4daa-bcaf-1c6bb87b63d1"
    val quantityPlusButton = Selenide.element(byXpath(QUANTITY_PLUS))
    val quantityMinusButton = Selenide.element(byXpath(QUANTITY_MINUS))
    val quantityInput = Selenide.element(byXpath(QUANTITY_INPUT))
    val addToCartButton = Selenide.element(byXpath(ADD_TO_CART_BUTTON))
    val cartSizeLabel = Selenide.element(byXpath(CART_SIZE_LABEL))
    val cartSizeLabelList = Selenide.elements(byXpath(CART_SIZE_LABEL))
    val buyNowButton = Selenide.element(byXpath(BUY_NOW_BUTTON))
    val accountNav = Selenide.element(byXpath(ACCOUNT_NAV))
    val accountNavList = Selenide.elements(byXpath(ACCOUNT_NAV))

    override fun open() {
        Selenide.open(pageUrl)
    }

    fun flexItem(groupIndex: Int, valueChooseIndex: Int): SelenideElement {
        return Selenide.element(byXpath(FLEX_GROUP + "div[$groupIndex]/div[1]/button[$valueChooseIndex]"))
    }

}