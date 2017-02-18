package selenium.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ListIterator;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebTest
{
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception 
	{
		//driver = new HtmlUnitDriver();
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void  tearDown() throws Exception
	{
		driver.close();
		driver.quit();
	}	
	
	@Test
	public void first() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dynamicStudies']/div[8]/div[2]/p/span[1]")));
		WebElement a =driver.findElement(By.xpath("//*[@id='dynamicStudies']/div[8]/div[2]/p/span[1]"));
		assertEquals("Matched", "55",a.getText());
	}
	
	@Test
	public void Second() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> spans = driver.findElements(By.xpath("//a[@class='status']/span[.='CLOSED']"));

		assertNotNull(spans);
		assertEquals(5, spans.size());
	}
	@Test
	public void Third() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='OPEN']/ancestor::a/following-sibling::p/following-sibling::div/button[.='Participate']")));
		Boolean x;
		List<WebElement> a = driver.findElements(By.xpath("//a[@class='status']/span[.='OPEN']/ancestor::a/following-sibling::p/following-sibling::div/button[.='Participate']"));
		
				for(int i=0;i<a.size();i++)
				{
					Boolean t=a.get(i).isEnabled();
					if(t==false){x=false;}
					assertNotNull(a.get(i));
				}
		
		assertEquals("Matched", true,x);	
	}
	@Test
	public void Fourth() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dynamicStudies']/div[12]/div[1]/h3/span[.='Software Changes Survey']/ancestor::h3/following-sibling::div[@class='award']/div/span/img")));
		
		WebElement a = driver.findElement(By.xpath("//*[@id='dynamicStudies']/div[12]/div[1]/h3/span[.='Software Changes Survey']/ancestor::h3/following-sibling::div[@class='award']/div/span/img"));
		
		
		int c=a.getAttribute("src").indexOf("/media/amazongc-micro.jpg");	
		assertNotEquals("Matched",-1,c);
		//assertEquals("s","/media/amazongc-micro.jpg",a.getAttribute("src"));
	}
	
}
