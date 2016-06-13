package com.jiedaibao.test;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jiedaibao.utils.Snapshot;
import com.jiedaibao.utils.WaitTool;

public class TestPCIndex {
	WebDriver driver;
	Snapshot snapshot;
	WaitTool waitTool;

	@BeforeMethod
	public void init() {
//		System.setProperty("webdriver.firefox.bin",
//				"D:/work/programFiles/firefox/firefox.exe");
//		System.setProperty("webdriver.chrome.driver",
//				"C:/Users/Administrator/AppData/Local/Google/Chrome/Application/chrome.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String url = "http://www.jiedaibao.com";
		driver.get(url);
		snapshot = new Snapshot();
		waitTool = new WaitTool();
	}
	
	@Test(description="首页的功能介绍验证")
	public void testFunction() {
		WebElement element = driver.findElement(By
						.cssSelector(".downloads .qr-area>.has-tips .custom-button-text"));
		waitTool.waitElement(driver, element);
		snapshot.getSnapshot((TakesScreenshot)driver, "1.png");
		Actions action = new Actions(driver);
		action.moveToElement(element).clickAndHold().build().perform();
		snapshot.getSnapshot((TakesScreenshot)driver, "moveto_QRcode.png");
		driver.close();
	}

//	@Test(description="立刻下载、观看视频、前往企业版")
//	public void testDownload(){
//		WebElement lastArrowButton = driver.findElement(By.cssSelector(".pointContainr>img:last-child"));
//		lastArrowButton.click();
//		WebElement downloadButton = driver.findElement(By.cssSelector(".bannerChoice.peopleBanner .downloadNow .innerContainer"));
//		Actions action = new Actions(driver);
//		action.moveToElement(downloadButton).clickAndHold().build().perform();
//		snapshot.getSnapshot((TakesScreenshot)driver, "moveto_download.png");
//		action.release(downloadButton).build().perform();
//		
//		WebElement videoButton = driver.findElement(By.cssSelector(".bannerChoice.peopleBanner .innerContainer.videoInner>span"));
//		action.moveToElement(videoButton).clickAndHold().build().perform();
//		action.release(videoButton).build().perform();
//		Assert.assertEquals(videoButton.getText().trim(), "观看视频");
//		snapshot.getSnapshot((TakesScreenshot)driver, "moveto_video.png");
//		WebElement closeButton = driver.findElement(By.cssSelector(".close"));
//		closeButton.click();
//		
//		WebElement firstArrowButton = driver.findElement(By.cssSelector(".pointContainr>img:first-child"));
//		firstArrowButton.click();
//		WebElement gotoQiyeButton = driver.findElement(By.cssSelector(".active #downloadContainer .innerContainer.videoInner>span"));
//		Assert.assertEquals(gotoQiyeButton.getText().trim(), "前往企业版", "前往企业版控件验证成功");
//		driver.close();
//	}
}
