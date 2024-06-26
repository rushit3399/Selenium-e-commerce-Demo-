package LearningNewSkills.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LearningNewSkills.pageObject.OrderHistoryPage;
import LearningNewSkills.pageObject.cartPage;



public class AbstractComponents {
	
	WebDriver driver;
	

	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*=cart]")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*=myorders]")
	WebElement orderHeader;


	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear() throws InterruptedException {
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//	wait.until(ExpectedConditions.invisibilityOf(ele));
		Thread.sleep(1000);
	}
	
	public cartPage goToCart() {
		cartHeader.click();
		cartPage cartpage = new cartPage(driver);
		return cartpage;
	}
	
	public OrderHistoryPage goToOrder() {
		orderHeader.click();
		OrderHistoryPage orderHistory = new OrderHistoryPage(driver);
		return orderHistory;
	}

}
