package TrelloMethods;
import org.openqa.selenium.WebDriver;

import TrelloPages.LoginPage;
public class Login {

	WebDriver driver;
	LoginPage loginPage=new LoginPage(driver);
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickMainLogin()
	{
		driver.findElement(loginPage.loginBtnMain).click();
		
	}
	public void setEmail(String email)
	{
		driver.findElement(loginPage.email).sendKeys(email);
	}
	public void clickContinueBtn()
	{
		driver.findElement(loginPage.contBtn).click();
		
	}
	public void clickLoginBtn()
	{
		driver.findElement(loginPage.loginBtn).click();
		
	}
	public void setPassword(String password)
	{
		driver.findElement(loginPage.password).sendKeys(password);
	}
	
}
