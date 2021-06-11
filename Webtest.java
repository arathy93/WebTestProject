package webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Webtest {
	Actions action;
	static WebDriverWait wait = null;
	
	public Webtest(WebDriver driver) {
		action = new Actions(driver);
		
	}
	
	public void pressEnter() {
		action.sendKeys(Keys.ENTER).build().perform();
		
	}
	
	public void scrollDown(WebDriver driver){
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,2000)", "");
	}
	
	public void performMouseHover(WebElement element) {
		action.moveToElement(element).build().perform();
	}
	
	public void clickUsingJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguements[0].click();", element);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/ajaykumar/Downloads/chromedriver 3");
		WebDriver driver  = new ChromeDriver();
		Webtest objWeb = new Webtest(driver);
		driver.get("https://www.amazon.de/");
		driver.manage().window().maximize();
																		
		//cheapest snickers
		WebElement inputSearch = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		inputSearch.sendKeys("cheapest Snickers and Skittles");
		objWeb.pressEnter();
		
		wait = new WebDriverWait(driver, 10);
		
		
		driver.findElement(By.linkText("Snickers Schokoriegel | Crisp | 24 Riegel in einer Box (24 x 40 g)")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		
		//cheapest skittles  
		WebElement inputSearch1 = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		inputSearch1.sendKeys("skittles");
		objWeb.pressEnter();
		
		wait = new WebDriverWait(driver, 10); 
		
		driver.get("https://www.amazon.de/Skittles-Fruits-Chewies-Kaubonbons-H%C3%BClle/dp/B07H9XL2CJ/ref=sr_1_5?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=skittles&qid=1623343783&sr=8-5");
		wait = new WebDriverWait(driver, 10); 
		
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		
		//checkout
		driver.findElement(By.xpath("//*[@id=\"hlb-ptc-btn-native\"]")).click();
	}

}
