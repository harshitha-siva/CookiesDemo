package cookieDemo;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class CapabilitiesDemo {
	
	@Test
	public void ModernOptions_desiredCapabilities() {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		try {
			driver.get("https://the-internet.herokuapp.com/");
			
			Capabilities caps = ((HasCapabilities)driver).getCapabilities();
			System.out.println("Browser: "+caps.getBrowserName());
			System.out.println("Browser version: "+caps.getBrowserVersion());
			System.out.println("Platform: "+caps.getPlatformName());
			System.out.println("Hash Code: "+caps.hashCode());
			System.out.println("String representation: "+caps.toString());
			System.out.println("Class: "+caps.getClass());
			
			
			
		}finally {
		
				if (driver != null) driver.quit();
			
			
		}
		
		
	}

}
