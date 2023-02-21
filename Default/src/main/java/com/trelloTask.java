package com;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class trelloTask {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		String url="https://trello.com/";
		String email="vsuman2354@gmail.com";
		String passwordText="peekaBoo@18";
		String boardTitle="TestBoard";
		String list1="List A";
		String list2="List B";
		String cardName="TestCard";
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("header[data-testid='bignav'] a[href='/login']")).click();
		//driver.wait(4000);
		driver.navigate().refresh();
		driver.findElement(By.id("user")).clear();
		driver.findElement(By.id("user")).sendKeys(email);
		driver.findElement(By.id("login")).click();
	
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		// click on the compose button as soon as the "compose" button is visible*/
		Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys(passwordText);
	/*	driver.findElement(By.id("password")).clear();
		//driver.wait(4000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);

		WebElement password = wait.until(driver1 -> {
				  return driver1.findElement(By.id("foo"));
				});
		password.sendKeys(passwordText);*/
		driver.findElement(By.id("login-submit")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("li[data-testid='create-board-tile']")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("input[data-testid='create-board-title-input']")).sendKeys(boardTitle);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("button[data-testid='create-board-submit-button']")).click();
		Thread.sleep(4000);
		//driver.findElement(By.cssSelector("#board form a")).click();
		Thread.sleep(4000);
		driver.findElement(By.className("list-name-input")).sendKeys(list1);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#board input[value='Add list']")).click();
		Thread.sleep(6000);
		//driver.findElement(By.cssSelector("#board form a")).click();
		
		driver.findElement(By.className("list-name-input")).sendKeys(list2);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#board input[value='Add list']")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#board a[class='open-card-composer js-open-card-composer']:nth-child(1)")).click();
		//driver.close();
		driver.findElement(By.cssSelector("#board div[class='list-card js-composer'] textarea")).sendKeys(cardName);
		driver.findElement(By.cssSelector("input[value='Add card']")).click();
		Actions act=new Actions(driver);
		WebElement from=driver.findElement(By.cssSelector("div > a > div[class='list-card-cover js-card-cover']"));
		WebElement to=driver.findElements(By.cssSelector("div > a > span[class='js-add-a-card']")).get(1);
		act.dragAndDrop(from, to).build().perform();
		Thread.sleep(4000);
		WebElement card=driver.findElement(By.cssSelector("div[class='list-card-details js-card-details']"));
		int x=card.getLocation().getX();
		int y=card.getLocation().getY();
		System.out.println("X point: "+x+" Y Point: "+y);
	}
	

}
