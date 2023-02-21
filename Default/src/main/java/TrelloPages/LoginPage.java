package TrelloPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	
	public By loginBtnMain= By.cssSelector("header[data-testid='bignav'] a[href='/login']");
	public By email=By.id("user");
	public By password=By.id("password");
	public By contBtn=By.id("login");
	public By loginBtn=By.id("login-submit");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

}
