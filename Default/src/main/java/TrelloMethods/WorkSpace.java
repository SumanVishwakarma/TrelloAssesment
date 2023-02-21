package TrelloMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import TrelloPages.BoardLandingPage;
import TrelloPages.BoardPage;

public class WorkSpace {

	WebDriver driver;
	BoardPage boardPage=new BoardPage(driver);
	BoardLandingPage boardLandingPage=new BoardLandingPage(driver);
	public WorkSpace(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickOnCreateBoard()
	{
		driver.findElement(boardPage.createBoard).click();
	}
	public void setBoardTitle(String boardTitle)
	{
		driver.findElement(boardPage.boardTitle).sendKeys(boardTitle);
	}
	public void clickOnCreateBtn()
	{
		driver.findElement(boardPage.createBtn).click();
	}
	public void setListTitle(String listTitle)
	{
		driver.findElement(boardLandingPage.listTitle).sendKeys(listTitle);
	}
	public void clickOnAddListBtn()
	{
		driver.findElement(boardLandingPage.addListBtn).click();
	}
	public void clickOnAddCard()
	{
		driver.findElement(boardLandingPage.addCard).click();
	}
	public void setCardTitle(String cardTitle)
	{
		driver.findElement(boardLandingPage.cardTitle).sendKeys(cardTitle);
	}
	public void clickOnAddCardBtn()
	{
		driver.findElement(boardLandingPage.addCardBtn).click();
	}
	public void dragAndDropCard()
	{
		Actions act=new Actions(driver);
		WebElement cardTo=driver.findElements(boardLandingPage.cardTo).get(1);
		WebElement cardFrom=driver.findElement(boardLandingPage.cardFrom);
		act.dragAndDrop(cardFrom,cardTo).build().perform();
	}
	public void getCoordinate()
	{
		WebElement cardLocation=driver.findElement(boardLandingPage.cardLocation);
		int x=cardLocation.getLocation().getX();
		int y=cardLocation.getLocation().getY();
		System.out.println("X point: "+x+" Y Point: "+y);
	}
	public void clickOnProfileMenu()
	{
		driver.findElement(boardLandingPage.profileBtn).click();
	}
	public void clickOnLogOut()
	{
		driver.findElement(boardLandingPage.logoutBtn).click();
		driver.findElement(boardLandingPage.logoutBtnMain).click();
	}
	
		
	
}
