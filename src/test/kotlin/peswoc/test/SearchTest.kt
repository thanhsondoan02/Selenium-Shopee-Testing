package peswoc.test

import com.codeborne.selenide.Condition.visible
import org.openqa.selenium.support.ui.ExpectedConditions.urlContains
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import peswoc.base.BaseTest
import peswoc.page.HomePage
import peswoc.page.SearchPage

class SearchTest : BaseTest<HomePage>(){
    override val page: HomePage
        get() = HomePage()

    var searchPage = SearchPage()

    @BeforeClass
    override fun beforeClass() {
        val loginTest = LoginTest()
        loginTest.holdBrowserOpen = true
        loginTest.beforeClass()
        loginTest.beforeMethod()
        loginTest.correctEmailAndPassword()
    }

    @Test
    fun checkSearchBoxHint() {
        page.listHintBox.shouldNotBe(visible)
        page.searchBox.sendKeys("iphone")
        page.listHintBox.shouldBe(visible)
    }

    @Test
    fun searchKey() {
        page.searchBox.sendKeys("dieu hoa")
        page.searchButton.click()
        wait.until(urlContains(HomePage.SEARCH_RESULT_URL))
        searchPage.firstSearchItem.click()
    }

}