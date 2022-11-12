package com.example.test2.page

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import com.example.test2.base.IBasePage

class SearchPage : IBasePage{

    companion object {
        const val PAGE_URL = "https://shopee.vn/search?keyword"
        const val FIRST_SEARCH_ITEM = "//div[@class='row shopee-search-item-result__items']/div[1]"
    }

    val firstSearchItem = Selenide.element(Selectors.byXpath(FIRST_SEARCH_ITEM))

    override fun open() {
        Selenide.open(PAGE_URL)
    }
}