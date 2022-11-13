package peswoc

import org.apache.commons.io.FileUtils
import org.openqa.selenium.*
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.print.PrintOptions
import java.io.File

fun main() {
    val driver = EdgeDriver()

    driver.manage().window().maximize()


    // convenient
    driver.get("http://selenium.dev")

    // longer way
    driver.navigate().to("http://selenium.dev")


    driver.currentUrl

    driver.navigate().back()

    driver.navigate().forward()

    driver.navigate().refresh()

    driver.title

    driver.windowHandle

    // store the ID of the original window
    val originalWindow = driver.windowHandle

    // check we don't have other windows open already
    assert(driver.windowHandles.size == 1)

    // click the link which opens in a new window
    driver.findElement(By.linkText("new window")).click()

    for (windowHandle in driver.windowHandles) {
        if (!originalWindow!!.contentEquals(windowHandle)) {
            driver.switchTo().window(windowHandle)
            break
        }
    }

    // open a new tab and switch to that tab
    driver.switchTo().newWindow(WindowType.TAB)

    // open a new window and switch to that window
    driver.switchTo().newWindow(WindowType.WINDOW)

    // close tab or window
    driver.close()

    // switch back to old tab or window
    driver.switchTo().window(originalWindow)

    driver.quit()

    driver.findElement(By.tagName("button")).click()

    // store the web element
    val iframe = driver.findElement(By.cssSelector("#modal>iframe"))

    // switch to the frame
    driver.switchTo().frame(iframe)

    // now we can click the button
    driver.findElement(By.tagName("button")).click()

    // using the ID
    driver.switchTo().frame("buttonFrame")

    // or using the name instead
    driver.switchTo().frame("myFrame")

    // now we can click the button
    driver.findElement(By.tagName("button")).click()

    // switch to the second frame
    driver.switchTo().frame(1)

    // return to the top level
    driver.switchTo().defaultContent()

    // access each dimension individually
    val width = driver.manage().window().size.width
    val height = driver.manage().window().size.height

    driver.manage().window().size = Dimension(1024, 768)

    // access each dimension individually
    val x =driver.manage().window().position.x
    val y =driver.manage().window().position.y

    // move to the top left or the primary monitor
    driver.manage().window().position = Point(0, 0)

    driver.manage().window().maximize()

    driver.manage().window().minimize()

    driver.manage().window().fullscreen()

    val srcFile = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
    FileUtils.copyFile(srcFile, File("./image.png"))

    val element = driver.findElement(By.id("tempID"))
    val srcFile2 = element.getScreenshotAs(OutputType.FILE)
    FileUtils.copyFile(srcFile2, File("./image.png"))

    val js = driver as JavascriptExecutor


    val button = driver.findElement(By.name("btnLogin"))

    js.executeScript("arguments[0].click()", button)


    val text = js.executeScript("return arguments[0].innerText", button)


    js.executeScript("console.log('Hello World')")


    driver.get("https://www.selenium.dev")
    val printer = driver as PrintsPage
    val printOptions = PrintOptions()
    printOptions.setPageRanges("1-2")


}
