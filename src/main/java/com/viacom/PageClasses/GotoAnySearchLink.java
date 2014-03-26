package com.viacom.PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GotoAnySearchLink {
	
	public WebDriver driver;
	public String textOnPage;
	
	public GotoAnySearchLink(WebDriver driver){
		this.driver=driver;
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
	
	}
	
	public String pageAfterClickingOnFirstLink(){
		textOnPage=driver.findElement(By.tagName("body")).getText();
		return textOnPage;
		
	}

}
