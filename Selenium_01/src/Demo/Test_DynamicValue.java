package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_DynamicValue {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium-2.47.1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com");
		driver.findElement(By.id("UHSearchBox")).sendKeys("Firepath");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[contains(., 'firepath addon')]")).click();	
		
		driver.close();
		
		
		

	}

}
