package peswoc.page

import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.support.ui.WebDriverWait
import peswoc.base.IBasePage

class ProductPage: IBasePage {

    companion object {
        const val PAGE_URL = "https://shopee.vn/K%C3%ADnh-c%C6%B0%E1%BB%9Dng-l%E1%BB%B1c-iphone-baiko-si%C3%AAu-c%E1%BB%A9ng-full-m%C3%A0n-6-6plus-6splus-7-7plus-8-8plus-x-xr-xs-11-12-13-promax-%E1%BB%90p-Awifi-D4-9-i.7669738.21240653463?sp_atk=37be6ce2-5101-4577-9a1d-2c22cf72595c&xptdk=37be6ce2-5101-4577-9a1d-2c22cf72595c"
        const val QUANTITY_PLUS = "//div[@class='_1RTqoK shopee-input-quantity']/button[2]"
        const val QUANTITY_MINUS = "//div[@class='_1RTqoK shopee-input-quantity']/button[1]"
        const val QUANTITY_INPUT = "//div[@class='_1RTqoK shopee-input-quantity']/input[1]"
        const val ADD_TO_CART_BUTTON = "//div[@class='_37uIr4']/button[1]"
        const val BUY_NOW_BUTTON = "//div[@class='_37uIr4']/button[2]"
        const val CART_SIZE_LABEL = "//div[@class='shopee-cart-number-badge']"
        const val FLEX_GROUP = "//div[@class='flex flex-column']/"
        const val ACCOUNT_NAV = "//li[@class='navbar__link navbar__link--tappable navbar__link--hoverable navbar__link--account']"
        const val IMAGE = "//div[@class='_3iW6K2']/div[@class='_1BkYjB _3DKwBj']"
        const val IMAGE_ZOOM = "//div[@class='_3iW6K2']/div[@class='FKTOVV _3DKwBj']"
        const val RATING_BUTTON = "//div[@class='product-rating-overview__filters']/div"
        const val STAR_ICON = "//div[@class='shopee-product-rating__rating']//*[name()='svg']"
        const val STAR_SOLID_CLASS="shopee-svg-icon icon-rating-solid--active icon-rating-solid"
        const val STAR_NOT_SOLID_CLASS="shopee-svg-icon icon-rating"
        const val PRODUCT_TYPE_LABEL = "//div[@class='flex items-center']/label"
        const val PRODUCT_TYPE_BUTTON_GROUP = "//div[@class='flex items-center']/div[@class='flex items-center _3Bh7nx']"
        const val PRODUCT_TYPE_BUTTON_SELECTED_CLASS = "product-variation product-variation--selected"
        const val TITLE = "//div[@class='_2rQP1z']/span"
    }

    val quantityPlusButton = Selenide.element(byXpath(QUANTITY_PLUS))
    val quantityMinusButton = Selenide.element(byXpath(QUANTITY_MINUS))
    val quantityInput = Selenide.element(byXpath(QUANTITY_INPUT))
    val addToCartButton = Selenide.element(byXpath(ADD_TO_CART_BUTTON))
    val cartSizeLabel = Selenide.element(byXpath(CART_SIZE_LABEL))
    val cartSizeLabelList = Selenide.elements(byXpath(CART_SIZE_LABEL))
    val buyNowButton = Selenide.element(byXpath(BUY_NOW_BUTTON))
    val accountNav = Selenide.element(byXpath(ACCOUNT_NAV))
    val accountNavList = Selenide.elements(byXpath(ACCOUNT_NAV))
    val imageList = Selenide.elements(byXpath(IMAGE))
    val imageZoom = Selenide.element(byXpath(IMAGE_ZOOM))
    val ratingButtonList = Selenide.elements(byXpath(RATING_BUTTON))
    val starIconList = Selenide.elements(byXpath(STAR_ICON))
    val productTypeLabelList = Selenide.elements(byXpath(PRODUCT_TYPE_LABEL))
    val productTypeButtonGroup = Selenide.elements(byXpath(PRODUCT_TYPE_BUTTON_GROUP))
    val title = Selenide.element(byXpath(TITLE))

    override fun open() {
        Selenide.open(PAGE_URL)
    }

    fun getTypeButton(groupIndex: Int, buttonIndex: Int): SelenideElement {
//        Selenide.element(byXpath("$PRODUCT_TYPE_BUTTON_GROUP$groupIndex/button[$buttonIndex]"))
        return productTypeButtonGroup[groupIndex].find(byXpath("button[${buttonIndex+1}]"))
    }

    fun flexItem(groupIndex: Int, valueChooseIndex: Int): SelenideElement {
        return Selenide.element(byXpath(FLEX_GROUP + "div[$groupIndex]/div[1]/button[$valueChooseIndex]"))
    }

    fun chooseItemAndClickAddCart() {
        //chooseAllType()
//        changeQuantity(addValue.last())
        addToCartButton.click()
    }

    fun chooseAllType(wait: WebDriverWait) {
        wait.until{ productTypeButtonGroup.size > 0 }
        for (i in 0 until productTypeButtonGroup.size) {
            getTypeButton(i, 0).click()
            wait.until{ getTypeButton(i, 0).getAttribute("class") == PRODUCT_TYPE_BUTTON_SELECTED_CLASS }
        }
    }

    fun changeQuantity(expectedQuantity: Int) {
        while (quantityInput.value!!.toInt() != expectedQuantity) {
            if (quantityInput.value!!.toInt() < expectedQuantity) {
                quantityPlusButton.click()
            } else {
                quantityMinusButton.click()
            }
        }
    }

    fun isButtonTypeSelected(button: SelenideElement): Boolean {
        return button.getAttribute("class") == PRODUCT_TYPE_BUTTON_SELECTED_CLASS
    }

}