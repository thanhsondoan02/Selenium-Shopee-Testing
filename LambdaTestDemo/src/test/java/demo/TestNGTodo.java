package demo;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.MoreCollectors;

public class TestNGTodo {

	public String username = "damanhduc140902";
	public String accesskey = "mr2dqkB6RkVjWvFk3eKHxArecyQ2V768Akh1f40lnGZqTDbj4u";
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	

	@BeforeClass
	public void setUp() throws Exception {
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("browserName", "chrome");
//		capabilities.setCapability("version", "70.0");
//		capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any
//															// available one
//		capabilities.setCapability("build", "MySampleBuildOne");
//		capabilities.setCapability("name", "MySampleTestOne");
//		capabilities.setCapability("network", true);
//		try {
//			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
//		} catch (MalformedURLException e) {
//			System.out.println("Invalid grid URL");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		EdgeOptions browserOptions = new EdgeOptions();
		browserOptions.setPlatformName("Windows 8");
		browserOptions.setBrowserVersion("107.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "damanhduc140902");
		ltOptions.put("accessKey", "mr2dqkB6RkVjWvFk3eKHxArecyQ2V768Akh1f40lnGZqTDbj4u");
		ltOptions.put("edge.popups", true);
		ltOptions.put("project", "Untitled");
		ltOptions.put("w3c", true);
		browserOptions.setCapability("LT:Options", ltOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void testLogin() throws Exception {
		driver.get("https://shopee.vn/buyer/login?is_from_login=true&next=https%3A%2F%2Fshopee.vn%2F%3Fis_from_login%3Dtrue");
		//driver.findElement(By.xpath("//div[@id='main']/div/div[2]/div/div/shopee-banner-popup-stateful")).click();
		//driver.findElement(By.linkText("Đăng Nhập")).click();

	    driver.findElement(By.name("loginKey")).click();
	    driver.findElement(By.name("loginKey")).clear();
	    driver.findElement(By.name("loginKey")).sendKeys("bihepimaidarl7@gmail.com");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("Abcd1234");
	    driver.findElement(By.xpath("//div[@id='main']/div/div[2]/div/div/div/div[2]/form/div/div[2]/button")).click();
	}
	
	@Test
	public void TestSearch() throws Exception {
		 driver.get("https://shopee.vn/buyer/login?is_from_login=true&next=https%3A%2F%2Fshopee.vn%2F%3Fis_from_login%3Dtrue");
		   // driver.findElement(By.name("loginKey")).clear();
		    driver.findElement(By.name("loginKey")).sendKeys("bihepimaidarl7@gmail.com");
		    driver.findElement(By.name("password")).click();
		    //driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("Abcd1234");
		    driver.findElement(By.xpath("//div[@id='main']/div/div[2]/div/div/div/div[2]/form/div/div[2]/button")).click();
		    driver.get("https://shopee.vn/?is_from_login=true&is_from_login=true");
		    
		    Thread.sleep(5000);
		    //driver.findElement(By.xpath("//*[@id='popsubform']/a/img")).click();
		    //driver.findElement(By.xpath("//div[@id='main']/div/div[2]/div/div/shopee-banner-popup-stateful")).click();
		    //driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();
		   // driver.findElement(By.xpath("//*[@id='main']/a/img")).click();
		    //driver.findElement(By.xpath("//div[@id='main']/div/div[2]/div/div/shopee-banner-popup-stateful")).click();
		    
//		    val root = driver.findElement(By.xpath("//shopee-banner-popup-stateful")).getShadowRoot();
//		    root.findElement(By.className("shopee-popup__close-btn")).click();
		    //driver.findElement(By.xpath("//shopee-banner-popup-stateful")).getShadowRoot().findElement(By.className("shopee-popup__close-btn")).click();
		    WebElement bannerPopUpStateful = driver.findElement(By.xpath("//shopee-banner-popup-stateful"));
	        SearchContext root = bannerPopUpStateful.getShadowRoot();
	        WebElement closeAdButton = root.findElement(By.className("shopee-popup__close-btn"));
	        closeAdButton.click();
		    
		    driver.findElement(By.xpath("//input[@value='']")).click();
		    driver.findElement(By.xpath("//input[@value='quan ao']")).clear();
		    driver.findElement(By.xpath("//input[@value='quan ao']")).sendKeys("quan ao");
		    driver.findElement(By.xpath("//button[@type='button']")).click();
		    driver.get("https://shopee.vn/search?keyword=quan%20ao");
		    driver.findElement(By.xpath("//div[@id='main']/div/div[2]/div/div/div[2]/div[2]/div[2]/div/a/div/div/div[2]/div/div/div")).click();
		    driver.get("https://shopee.vn/%C4%90%E1%BB%93-B%E1%BB%99-Nam-4-M%C3%A0u-%C4%90%C5%A9i-D%C3%A0i-V%C3%A0-Ng%E1%BA%AFn-Nam-H%C3%A0ng-%C4%90%C5%A9i-M%E1%BA%B7c-M%C3%A1t-Xu-h%C6%B0%E1%BB%9Bng-M%E1%BB%9Bi-D01-i.347027604.16900095900?sp_atk=81f8420c-812b-4c36-bbf8-157aba1fa830&xptdk=81f8420c-812b-4c36-bbf8-157aba1fa830");
	}

	@AfterClass
	public void tearDown() throws Exception {
		if (driver != null) {
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
			driver.quit();
		}
	}
}
