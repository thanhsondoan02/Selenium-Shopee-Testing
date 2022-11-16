package peswoc.test

import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.annotations.Test
import peswoc.base.BaseTest
import peswoc.page.ProductPage

class ViewProductTest: BaseTest<ProductPage>() {

    override val page: ProductPage
        get() = ProductPage()

    private var plusClick = 4
    private var minusClick = 2

    @Test
    fun testChangeQuantity() {
        var expectedQuantity = page.quantityInput.value!!.toInt()

        // increase quantity
        for (i in 1..plusClick) {
            page.quantityPlusButton.click()
            expectedQuantity++
            wait.until(ExpectedConditions.textToBePresentInElementValue(page.quantityInput, expectedQuantity.toString()))
        }

        // decrease quantity
        for (i in 1..minusClick) {
            page.quantityMinusButton.click()
            if (expectedQuantity > 1) expectedQuantity--
            wait.until(ExpectedConditions.textToBePresentInElementValue(page.quantityInput, expectedQuantity.toString()))
        }
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