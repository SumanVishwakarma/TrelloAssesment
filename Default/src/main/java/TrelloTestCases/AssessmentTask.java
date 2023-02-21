package TrelloTestCases;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TrelloMethods.*;
import TrelloPages.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AssessmentTask{

	
	WebDriver driver=new ChromeDriver();
	Properties props=new Properties();
	//FileReader reader=new FileReader("C:\\Users\\vsuma\\eclipse-workspace\\Default\\src\\main\\java\\TrelloData\\data.properties");
	FileInputStream fis;

    {
        try {
            fis = new FileInputStream("C:\\\\Users\\\\vsuma\\\\eclipse-workspace\\\\Default\\\\src\\\\main\\\\java\\\\TrelloData\\\\data.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setUp() throws Exception
	{
		
	
		props.load(fis);
		driver.manage().window().maximize();
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@BeforeTest
	public void Login() throws Exception
	{
		props.load(fis);
		Login login=new Login(driver);
		login.clickMainLogin();
		login.setEmail(props.getProperty("email"));
		login.clickContinueBtn();
		Thread.sleep(5000);
		login.setPassword(props.getProperty("password"));
		login.clickLoginBtn();
	}
	@Test(priority=1)
	public void createBoard() throws IOException
	{
		props.load(fis);
		WorkSpace workSpace=new WorkSpace(driver);
		workSpace.clickOnCreateBoard();
		workSpace.setBoardTitle(props.getProperty("boardTitle"));
		workSpace.clickOnCreateBtn();
		
	}
	@Test(priority=2)
	public void createList() throws Exception
	{
		props.load(fis);
		WorkSpace workSpace=new WorkSpace(driver);
		workSpace.setListTitle(props.getProperty("list1"));
		workSpace.clickOnAddListBtn();
		Thread.sleep(4000);
		workSpace.setListTitle(props.getProperty("list2"));
		workSpace.clickOnAddListBtn();
	}
	
	@Test(priority=3)
	public void createCard() throws Exception
	{
		props.load(fis);
		WorkSpace workSpace=new WorkSpace(driver);
		workSpace.clickOnAddCard();
		workSpace.setCardTitle(props.getProperty("cardName"));
		
		
		workSpace.clickOnAddCardBtn();
	}
	@Test(priority=4)
	public void moveCard() throws Exception
	{
		WorkSpace workSpace=new WorkSpace(driver);
		workSpace.dragAndDropCard();
		workSpace.getCoordinate();
	}
	
	@AfterTest
	public void LogOut()
	{
		WorkSpace workSpace=new WorkSpace(driver);
		workSpace.clickOnProfileMenu();
		workSpace.clickOnLogOut();
	}
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}
