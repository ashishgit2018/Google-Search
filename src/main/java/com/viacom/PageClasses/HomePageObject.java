//All functions related to opening browser and navigating to the google page , performing
//the insert search term operations and clicking submit button

package com.viacom.PageClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.viacom.googlesearch.GoogleDriver;

public class HomePageObject {
	
	public WebDriver driver;
	private WebElement elementTextField;
	private WebElement elementSubmitBtn;
	
	
	public void getPage(String url){
		//open page using customized browser
		driver=GoogleDriver.get(url);
		new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Google"));
	}
	public String titleOfPage(){
		return driver.getTitle();
	}
		
	public void enterSerachContent(String searchTerm){
		elementTextField=driver.findElement(By.id("gbqfq"));
		elementTextField.sendKeys(searchTerm);
	}
	
	public void clickSubmitButton(){
		elementSubmitBtn=driver.findElement(By.id("gbqfb"));
		elementSubmitBtn.click();
	}
	
	public GotoSerachPage enterSerachTermAndClick(String searchTerm){
		enterSerachContent(searchTerm);
		clickSubmitButton();
		
		return new GotoSerachPage(driver);
	}
	
	public void closeDriver(){
		GoogleDriver.quit();
	}
}
