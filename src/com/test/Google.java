package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class Google {
 
 private Selenium selenium;

 @Parameters({"browser","port"})
 @BeforeMethod
 public void beforeClass(String browser,String port){
  DesiredCapabilities capability= new DesiredCapabilities();
  capability.setBrowserName(browser);
  try {
   WebDriver driver= new RemoteWebDriver(new URL("http://localhost:".concat(port).concat("/wd/hub")), capability);
   selenium = new WebDriverBackedSelenium(driver, "http://www.google.com");
  } catch (MalformedURLException e) {
    
   e.printStackTrace();


  }
 }
  
 @Test
 public void search() {
  selenium.open("/");
  selenium.type("id=lst-ib", "testing");
  selenium.click("//input[@value='Google Search']");
  }

  
}