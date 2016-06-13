package com.jiedaibao.pageobjects;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.jiedaibao.utils.Snapshot;
import com.jiedaibao.utils.WaitTool;

public class PcIndexPage {
	
	@FindBy(css = ".pointContainr>img:last-child")
	private WebElement lastArrowButton;
	
	@FindBy(css = ".bannerChoice.peopleBanner .downloadNow .innerContainer")
	private WebElement downloadButton;
	
	@FindBy(css = ".bannerChoice.peopleBanner .innerContainer.videoInner>span")
	private WebElement videoButton;
	
	@FindBy(css = ".close")
	private WebElement closeButton;
	
	@FindBy(css = ".pointContainr>img:first-child")
	private WebElement firstArrowButton;
	
	@FindBy(css = ".active #downloadContainer .innerContainer.videoInner>span")
	private WebElement gotoQiyeButton;
	
	private WebDriver driver;
	private Snapshot snapshot;
	private WaitTool waitTool;

	public PcIndexPage(WebDriver driver) {
		this.driver = driver;
		snapshot = new Snapshot();
		waitTool = new WaitTool();
		waitTool.waitElement(driver, lastArrowButton);
	}
	
	public void verifyDownloadButton(){
		lastArrowButton.click();
		Actions action = new Actions(driver);
		action.moveToElement(downloadButton).clickAndHold().build().perform();
		snapshot.getSnapshot((TakesScreenshot)driver, "moveto_download.png");
		action.release(downloadButton).build().perform();
	}
	
	public void verifyVideoButton(){
		Actions action = new Actions(driver);
		action.moveToElement(videoButton).clickAndHold().build().perform();
		action.release(videoButton).build().perform();
		Assert.assertEquals(videoButton.getText().trim(), "观看视频");
		snapshot.getSnapshot((TakesScreenshot)driver, "moveto_video.png");
		closeButton.click();
	}
	
	public void verfyGotoQiyeButton(){
		firstArrowButton.click();
		snapshot.getSnapshot((TakesScreenshot)driver, "gotoQiyeButton.png");
		Assert.assertEquals(gotoQiyeButton.getText().trim(), "前往企业版", "前往企业版控件验证成功");
	}

}
