package peswoc.test

import org.testng.annotations.Test
import peswoc.base.BaseTest
import peswoc.page.ProductPage

class ViewProductTest: BaseTest<ProductPage>() {

    override val page: ProductPage
        get() = ProductPage()

    init {
        holdBrowserOpen = true
    }

    @Test
    fun viewProductImage() {
        // click to image to zoom
        page.imageList[1].click()
        // check if image zoom is displayed
        wait.until { page.imageZoom.isDisplayed }
    }

    @Test
    fun viewOneStarRatings() {
        // click to 1 star button
        page.ratingButtonList[5].click()
        // wait for 2 seconds
        Thread.sleep(2000)
        // check if all rating is 1 star
        assert(isOneStarList())
    }

    private fun isOneStarList(): Boolean {
        for (i in 0 until page.starIconList.size) {
            if (i % 5 == 0) {
                if (page.starIconList[i].getAttribute("class") != ProductPage.STAR_SOLID_CLASS) return false
            } else {
                if (page.starIconList[i].getAttribute("class") != ProductPage.STAR_NOT_SOLID_CLASS) return false
            }
        }
        return true
    }

}