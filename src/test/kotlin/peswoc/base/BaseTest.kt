package peswoc.base

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverRunner
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import java.time.Duration

abstract class BaseTest<Page: IBasePage> : IBaseTest {

    companion object {
        const val DEFAULT_WAITING_SECONDS = 4L
    }

    abstract override val page: Page

    override var waitSecond = DEFAULT_WAITING_SECONDS
    override var holdBrowserOpen = false

    override val wait
        get() = WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(waitSecond))

    @BeforeClass
    override fun beforeClass() {
        Configuration.browserSize = "1920x1080"
        Configuration.browser = "edge"
        Configuration.holdBrowserOpen = holdBrowserOpen
    }

    @BeforeMethod
    override fun beforeMethod() {
        loadPage()
    }

    @AfterMethod
    override fun afterMethod() {
    }

    override fun deleteCache() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies()
    }

    override fun loadPage() {
        page.open()
    }
}