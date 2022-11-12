package com.example.test2.page

import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import com.example.test2.base.IBasePage

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

    var pageUrl: String = "https://shopee.vn/%C4%90i%E1%BB%81u-h%C3%B2a-Casper-9000BTU-12000BTU-18000BTU-24000BTU-1-chi%E1%BB%81u-2-chi%E1%BB%81u-Inverter-M%E1%BB%9Bi-100-h%C3%A0ng-ch%C3%ADnh-h%C3%A3ng-BH-3-n%C4%83m--i.286675562.7480762944?sp_atk=b798a6b2-1a14-4660-81c1-6e425de130fe&xptdk=b798a6b2-1a14-4660-81c1-6e425de130fe"
//    var pageUrl: String = "https://shopee.vn/%C4%90i%E1%BB%81u-h%C3%B2a-Casper-9000BTU-12000BTU-18000BTU-24000BTU-1-chi%E1%BB%81u-2-chi%E1%BB%81u-Inverter-M%E1%BB%9Bi-100-h%C3%A0ng-ch%C3%ADnh-h%C3%A3ng-BH-3-n%C4%83m--i.286675562.7480762944?sp_atk=b798a6b2-1a14-4660-81c1-6e425de130fe&xptdk=b798a6b2-1a14-4660-81c1-6e425de130fe&is_from_login=true"
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