package com.example.test2.home

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide

class HomePage {

    companion object {
        const val PAGE_URL = "https://shopee.vn/"
        const val SEARCH_BOX = "//input[@class='shopee-searchbar-input__input']"
        const val SEARCH_BUTTON = "//button[@class='btn btn-solid-primary btn--s btn--inline shopee-searchbar__search-button']"
        const val POP_UP_CLOSE_BUTTON = "/html/body/div[1]/div/div[2]/div/div/shopee-banner-popup-stateful//div/div/div/div/div"
    }

    val searchBox = Selenide.element(Selectors.byXpath(SEARCH_BOX))
    val searchButton = Selenide.element(Selectors.byXpath(SEARCH_BUTTON))
    val popUpCloseButton = Selenide.element(Selectors.byXpath(POP_UP_CLOSE_BUTTON))

    fun open() {
        Selenide.open(PAGE_URL)
    }

}