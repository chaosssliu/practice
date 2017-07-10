package net.antra.test.auto;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

public class SeleniumTest {
	static WebDriver driver;
	static Wait<WebDriver> wait;

	@BeforeClass
	public static void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/daweizhuang/workspace/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
	}
	@Test
	public void loginTest() {
		driver.get("http://www.facebook.com");
		boolean result = driver.findElement(By.id("pagelet_bluebar")).isDisplayed();
		assertTrue(result);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("antra");
		driver.findElement(By.id("pass")).sendKeys("antra");
		driver.findElement(By.id("u_0_n")).click();
	}
//	@Test
//	public void loginTest() {
//		driver.get("http://localhost:8080/");
//		boolean result;
//		try {
//			String displayCss = driver.findElement(By.id("access_wiki_modal_dialog")).getCssValue("display");
//			result = "block".equalsIgnoreCase(displayCss);
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = false;
//		}
//		assertTrue(result);
//	}
//
//	@Test
//	public void inputAccessCodeTest1Wrongly() {
//		boolean result;
//		try {
//			result = wrongAccessCode();
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = false;
//		}
//		assertTrue(result);
//	}
//
//	@Test
//	public void inputAccessCodeTest2Correctly() {
//		boolean result;
//		try {
//			result = correctAccessCode();
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = false;
//		}
//		assertTrue(result);
//	}
//
//	private boolean wrongAccessCode() {
//		boolean result;
//		driver.findElement(By.id("access_code")).sendKeys("antra");
//		driver.findElement(By.id("save_access_button")).click();
//		result = driver.findElement(By.className("alert-danger")).isDisplayed();
//		return result;
//	}
//
//	private boolean correctAccessCode() {
//		boolean result;
//		driver.findElement(By.id("access_code")).sendKeys("0216");
//		driver.findElement(By.id("save_access_button")).click();
//		result = driver.findElement(By.className("bs-docs-section")).isDisplayed();
//		return result;
//	}

	@AfterClass
	public static void close() {
		//driver.close();
	}
}
