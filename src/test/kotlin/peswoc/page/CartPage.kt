package peswoc.page

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import peswoc.base.IBasePage

class CartPage : IBasePage {

    companion object {
        const val PAGE_URL = "https://shopee.vn/cart"
        const val PRODUCT_TITLE = "//a[@class='_2fQT1K']"
        const val PRODUCT_NUMBER = "//input[@class='EcPhjV _3cj9Np']"
        const val DELETE_BUTTON = "//div[@class='_2y8iJi _2qPRqW']/button[@class='RCd1Gx']"
    }

    val productTitleList: MutableList<String> = Selenide.elements(Selectors.byXpath(PRODUCT_TITLE)).texts()
    private val productNumberList = Selenide.elements(Selectors.byXpath(PRODUCT_NUMBER))
    val deleteButtonList = Selenide.elements(Selectors.byXpath(DELETE_BUTTON))

    override fun open() {
        Selenide.open(PAGE_URL)
    }

//    fun getProductTitleList(): List<String> {
//        val list = mutableListOf<String>()
//        productTitleList.forEach {
//            list.add(it.text())
//        }
//        return list
//    }

    fun getProductNumberList(): List<Int> {
        val list = mutableListOf<Int>()
        productNumberList.forEach {
            list.add(it.getAttribute("value")!!.toInt())
        }
        return list
    }

}