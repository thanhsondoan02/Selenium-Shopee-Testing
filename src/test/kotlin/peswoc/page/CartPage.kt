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
        const val CHECK_PRODUCT_BOX = "//div[@class='stardust-checkbox__box']"
        const val ORDER_BUTTON = "//button[@class='shopee-button-solid shopee-button-solid--primary']"
        const val LABEL_CHECK_BOX = "//label[@class='stardust-checkbox stardust-checkbox--checked']"
        const val ALERT_CLOSE_BUTTON = "//div[@class='shopee-alert-popup__button-horizontal-layout']/button[@class='shopee-button-solid shopee-button-solid--primary']"
    }

    val productTitleList: MutableList<String> = Selenide.elements(Selectors.byXpath(PRODUCT_TITLE)).texts()
    private val productNumberList = Selenide.elements(Selectors.byXpath(PRODUCT_NUMBER))
    val deleteButtonList = Selenide.elements(Selectors.byXpath(DELETE_BUTTON))
    val orderButton = Selenide.element(Selectors.byXpath(ORDER_BUTTON))
    val checkProductBoxes = Selenide.elements(Selectors.byXpath(CHECK_PRODUCT_BOX))
    val labelCheckBoxes = Selenide.elements(Selectors.byXpath(LABEL_CHECK_BOX))
    val alertCloseButton = Selenide.element(Selectors.byXpath(ALERT_CLOSE_BUTTON))

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

    fun tickFirstProduct() {
        checkProductBoxes[2].click()
    }

}