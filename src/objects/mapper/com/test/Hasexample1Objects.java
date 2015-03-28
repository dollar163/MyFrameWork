package objects.mapper.com.test;

import atu.sob.exceptions.ObjectBankException;
import atu.sob.exceptions.ObjectFinderException;
import atu.sob.utils.ObjectIdentifier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Hasexample1Objects {

	private WebDriver driver = null;
	private ObjectIdentifier identifier = new ObjectIdentifier();
	
	public void setWebDriverObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement username() throws ObjectBankException, ObjectFinderException  {
		return identifier.findElement(driver);
	}


	public WebElement password() throws ObjectBankException, ObjectFinderException  {
		return identifier.findElement(driver);
	}


	public WebElement signIN() throws ObjectBankException, ObjectFinderException  {
		return identifier.findElement(driver);
	}


	public WebElement checkbox() throws ObjectBankException, ObjectFinderException  {
		return identifier.findElement(driver);
	}

}
