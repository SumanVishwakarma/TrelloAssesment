package TrelloPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardPage {
	WebDriver driver;
	public By createBoard=By.cssSelector("li[data-testid='create-board-tile']");
	public By boardTitle=By.cssSelector("input[data-testid='create-board-title-input']");
	public By createBtn=By.cssSelector("button[data-testid='create-board-submit-button']");
	
	public BoardPage(WebDriver driver)
	{
		this.driver=driver;
	}
}
