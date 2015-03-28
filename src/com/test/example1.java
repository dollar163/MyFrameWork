package com.test;

import objects.mapper.com.test.Hasexample1Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.sob.exceptions.ObjectFinderException;

public class example1 extends Hasexample1Objects {
	WebDriver driver;

	@BeforeTest
	public void login() {
		setWebDriverObject(driver);

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		WebDriver driver = new FirefoxDriver(myprofile);
		driver.get("https://login.yahoo.com");

	}

	@Test
	public void es() throws Exception, ObjectFinderException {
		setWebDriverObject(driver);
		Thread.sleep(5000);
		username().sendKeys("hari");
		password().sendKeys("charan");

		checkbox();
		WebElement element = driver.findElement(By
				.xpath("//label[@for='persistent']"));
		Coordinates coordinate = ((Locatable) element).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		System.out.println(signIN().getCssValue("color"));
		signIN();

	}

}
