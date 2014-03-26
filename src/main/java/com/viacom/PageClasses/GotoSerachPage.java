package com.viacom.PageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GotoSerachPage {
	
	public WebDriver driver;
	public WebElement searchedElements;
	public WebElement firstLinkToClick;
	
	public GotoSerachPage(WebDriver driver){
		this.driver=driver;
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("g")));
	}
	
	
	
	public List<String> testIfEachResultContainsTheSearchedWord(){
		List<WebElement> allElements = driver.findElements(By.xpath("//li[@class='g']//h3/a[1]"));
		List<String> allLinks=new ArrayList<String>();
		for(WebElement e:allElements){
			allLinks.add(e.getText().toString());
		}
		return allLinks;
		
	}
	
	public GotoAnySearchLink clickFirstLink(){
		//click on the first link
		firstLinkToClick=driver.findElement(By.xpath("//li[@class='g'][1]//h3/a[1]"));
		firstLinkToClick.click();
		return new GotoAnySearchLink(driver);
		
	}

	
	

}
