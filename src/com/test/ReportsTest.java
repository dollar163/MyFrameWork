package com.test;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

//@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
		MethodListener.class })
public class ReportsTest {

	{
		System.setProperty("atu.reporter.config",
				"f:\\Eclipse\\lib\\Atureports\\atu.properties");
	}

	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
	 driver = new FirefoxDriver();
		baseUrl = "https://www.google.co.in";
		driver.get(baseUrl);

		// ATU Reports
		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";
	}

	@Test
	public void GoogleTooltip() throws Exception, SQLException {
		String expect = "Google";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expect);
		ATUReports.setAuthorInfo("hari", Utils.getCurrentTime(),"2.42");

	}

	// ATU Reports Method
	@Test
	public void testNewLogs() throws AWTException, IOException, Exception {

		Thread.sleep(5000);
		ATUReports.setAuthorInfo("hari", Utils.getCurrentTime(),"2.42");
		ATUReports.setTestCaseReqCoverage("rapid");
		ATUReports.add("hi this is hari", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
		WebElement element = driver
				.findElement(By
						.xpath("//img[@src='/logos/doodles/2015/nowruz-2015-5684600579817472-hp.jpg']"));
		if(element.isDisplayed())
		{
		ATUReports.add("this is passed", LogAs.PASSED,
				new CaptureScreen(element));
		}
		else
		{
			ATUReports.add("failed", LogAs.FAILED, new CaptureScreen(element));
		}
		Thread.sleep(3000);
		

	}

}