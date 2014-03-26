/* This java class is used to created a customized webdriver to run tests on different browsers
 */
package com.viacom.googlesearch;
 

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;

public class GoogleDriver {

	private static BrowserName useThisDriver;
	//Any of the browsers can be used.currently working to incorporate Sauce labs also
	private enum BrowserName{FIREFOX, GOOGLECHROME, OPERA, IE, HTMLUNIT}
	private static WebDriver adriver=null;
	private static String defaultBrowser=null;

	 public static WebDriver get(String url) {
		
		//currently using IE .Change the value to use any other browser from the list
		defaultBrowser = "IE"; 
        switch (defaultBrowser){
        
            case "FIREFOX":
                useThisDriver = BrowserName.FIREFOX;
                break;
                
            case "CHROME":
                useThisDriver = BrowserName.GOOGLECHROME;
                break;
                
            case "IE":
                useThisDriver = BrowserName.IE;
                break;
                
            case "OPERA":
                useThisDriver = BrowserName.OPERA;
                break;
                
            case "HTMLUNIT":
                useThisDriver = BrowserName.HTMLUNIT;
                break;
                
            default:
            	useThisDriver = BrowserName.FIREFOX;
	}
        if(adriver==null){
        	
        	switch(useThisDriver){
        	
        	case FIREFOX:
        		adriver=new FirefoxDriver();
        		FirefoxProfile profile = new FirefoxProfile();
                profile.setEnableNativeEvents(true);
             break;
             
        	case GOOGLECHROME:
        		System.setProperty("webdriver.chrome.driver", "D://Drivers//chromedriver.exe");
        		adriver=new ChromeDriver();
        		break;
        		
        	case IE:
        		System.setProperty("webdriver.ie.driver","D://Drivers//IEDriverServer.exe");
        		adriver=new InternetExplorerDriver();
        		break;
        		
        	case OPERA:
        		adriver= new OperaDriver();
        		break;
        		
        	case HTMLUNIT:
        		adriver=new HtmlUnitDriver();
        		break;
        	}
        }
        else{
        	
        try{
            // is browser still alive
            if(adriver.getWindowHandle()!=null){
                // assume it is still alive
            }
        }catch(Exception e){
           
        	throw new RuntimeException();
            }

            quit();
            adriver=null;
           
        }
	 
          if(adriver!=null){
        	  adriver.get(url);
        	  adriver.manage().deleteAllCookies();
        	  try{
                  adriver.manage().window().maximize();
              }catch(UnsupportedCommandException e){
                  System.out.println("Remote Driver does not support maximise");
              }catch(UnsupportedOperationException e){
                  System.out.println("Opera driver does not support maximize yet");
              }
          }
          return adriver;

}
	 
	 public static void quit(){
	        if(adriver!=null){
	            try{
	                adriver.quit();
	                adriver=null;
	            	}catch(Exception e){
	               
	            }

	        }
}
}
