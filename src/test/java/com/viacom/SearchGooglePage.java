package com.viacom;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.viacom.PageClasses.GotoAnySearchLink;
import com.viacom.PageClasses.GotoSerachPage;
import com.viacom.PageClasses.HomePageObject;

public class SearchGooglePage {
	
	private final static String LINK_TO_Test="https://www.google.com";
	//change serach term here
	private final static String SEARCH_STRING="India";
	private HomePageObject newPage=new HomePageObject();
	private GotoSerachPage pageAfterClick;
	private GotoAnySearchLink searchLink;
	
	@BeforeTest
	public void navigateToGoogleLinkTest(){
		newPage.getPage(LINK_TO_Test);
		
	}
	
	@Test
	public void googleSearchTest(){
		
		Assert.assertEquals(newPage.titleOfPage(), "Google");

		pageAfterClick=newPage.enterSerachTermAndClick(SEARCH_STRING);
		Assert.assertEquals(newPage.titleOfPage(),SEARCH_STRING+" - Google Search");

		List<String> allElements=(List<String>) pageAfterClick.testIfEachResultContainsTheSearchedWord();

		for(String e:allElements){
			System.out.println(e);
			if(e.contains(SEARCH_STRING)){
				Assert.assertTrue(true, e+" Contains text "+SEARCH_STRING);
			}
		}
		
		searchLink=pageAfterClick.clickFirstLink();
		if (searchLink.pageAfterClickingOnFirstLink().contains(SEARCH_STRING)){
			Assert.assertTrue(true, "Search page contains text "+SEARCH_STRING);
		}
		
	}
	
	@AfterTest
	public void closeDriverTest(){
		newPage.closeDriver();
	}
		
	
}
