package Demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetListDropdown {
	public static void main(String[] args) {
		
		// Initialise Driver
				System.setProperty("webdriver.chrome.driver", "E:\\selenium-2.47.1\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.facebook.com");			
				
				WebElement monthdrop = driver.findElement(By.id("month"));
				
				List<WebElement> options = monthdrop.findElements(By.tagName("option"));
				ArrayList<String> Month_List = new ArrayList<String>();
				
				for(WebElement option: options){
					System.out.println(option.getText());
					Month_List.add(option.getText());
				}			
				driver.close();
	}
}
