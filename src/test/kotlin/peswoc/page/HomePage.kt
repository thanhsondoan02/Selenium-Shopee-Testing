package peswoc.page

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.WebDriverRunner
import org.openqa.selenium.By
import peswoc.base.IBasePage

class HomePage: IBasePage {

    companion object {
        const val PAGE_URL = "https://shopee.vn/"
        const val SEARCH_RESULT_URL = "https://shopee.vn/search?keyword"

        const val SEARCH_BOX = "//input[@class='shopee-searchbar-input__input']"
        const val SEARCH_BUTTON = "//button[@class='btn btn-solid-primary btn--s btn--inline shopee-searchbar__search-button']"
        const val POP_UP_CLOSE_BUTTON = "//div[@class='home-popup__close-area']"
        const val POP_UP_CONTENT = "//a[@target='_self']"
        const val LIST_HINT_BOX = "//div[@id='shopee-searchbar-listbox']"
        const val CLOSE_AD_BUTTON = "//div[@class='shopee-popup__close-btn']"
    }

    val searchBox = element(Selectors.byXpath(SEARCH_BOX))
    val searchButton = element(Selectors.byXpath(SEARCH_BUTTON))
    val popUpCloseButton = element(Selectors.byXpath(POP_UP_CLOSE_BUTTON))
    val popUpContent = element(Selectors.byXpath(POP_UP_CONTENT))
    val listHintBox = element(Selectors.byXpath(LIST_HINT_BOX))

    override fun open() {
        Selenide.open(PAGE_URL)
    }

    fun closePopUp() {
        val bannerPopUpStateful = WebDriverRunner.getWebDriver().findElement(Selectors.byXpath("//shopee-banner-popup-stateful"))
        val root = bannerPopUpStateful.shadowRoot
        val closeAdButton = root.findElements(By.className("shopee-popup__close-btn"))
        closeAdButton.getOrNull(0)?.click()
    }

}