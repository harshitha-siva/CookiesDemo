package cookieDemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class cookiePractice {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@AfterMethod(alwaysRun =true)
	public void tearDown() {
		if (driver != null) driver.quit();
	}
	
	@Test
	
	public void addAndDeleteCookies() {
		
		driver.get("https://the-internet.herokuapp.com/");
		
		Cookie myCookie =new Cookie("nameCookie","Harshitha");
		driver.manage().addCookie(myCookie);
		
		
		Cookie fetched =driver.manage().getCookieNamed("nameCookie");
		System.out.println("My Cookie name is : "+fetched.getValue());
		
		Assert.assertNotNull(fetched, "Cookie not added");
		Assert.assertEquals(fetched.getValue(),"Harshitha", "Cookie value mismatch!");
		
		System.out.println("Added cookie: "+fetched);
		
		System.out.println("Domain of cookie is: "+fetched.getDomain());
		System.out.println("Path of cookie is: "+fetched.getPath());
		System.out.println("Hash Code of cookie is: "+fetched.hashCode());
		System.out.println("Expiry of cookie is: "+fetched.getExpiry());
		System.out.println("Security of cookie is: "+fetched.isSecure());
		System.out.println("HttpOnly of cookie is: "+fetched.isHttpOnly());
		System.out.println("String representation of cookie is: "+fetched.toString());
		fetched.validate(); 
		System.out.println("Validation of cookie is complete");
		System.out.println("Class of cookie is: "+fetched.getClass());
		
		
		
		/*
		
		Set <Cookie> all = driver.manage().getCookies();
		System.out.println("Total cookies now: "+all.size());
		
		for(Cookie c: all) {
			System.out.println("Cookie -> "+c.getName()+" = "+c.getValue());
		}
		
		driver.manage().deleteCookieNamed("nameCookie");
		
		Cookie afterDelete = driver.manage().getCookieNamed("nameCookie");
		Assert.assertNull(afterDelete,"Cookie was not deleted");
		
		System.out.println("Deleted Cookie nameCookie");
		
		driver.manage().deleteAllCookies();
		
		Assert.assertEquals(driver.manage().getCookies().size(),0, "all cookies are deleted");
		System.out.println("Deleted all cookies");*/
		
		
		
			
	}
	

}
