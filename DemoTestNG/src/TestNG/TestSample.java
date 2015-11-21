package TestNG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestSample {

	public void fbLogin() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com");			
			
			WebElement monthdrop = driver.findElement(By.id("month"));
			
			List<WebElement> options = monthdrop.findElements(By.tagName("option"));
			ArrayList<String> Month_List = new ArrayList<String>();
			
			for(WebElement option: options){
				Month_List.add(option.getText());
			}
			System.out.println("FB_Month List- " + Month_List);
			//return Month_List;
			driver.close();
	  	
		//@Test
	  //public void DB_Test(){

			Connection conn = null;			
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String databaseName = "my_db";
			String username = "root";
			String password = "root";
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url+databaseName, username, password);
				
				String sqlQuerry = "SELECT * FROM my_db.months";
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sqlQuerry);
				
				ArrayList<String> monthID = new ArrayList<String>();
				ArrayList<String> monthName = new ArrayList<String>();
				
				while(result.next()){
					//System.out.print(result.getString(1));
					monthID.add(result.getString(1));
					//System.out.print("\t" + result.getString(2));
					monthName.add(result.getString(2));
				}
				System.out.println("DB Query O/P: " + monthName);
				//return monthName;
				Assert.assertEquals(monthName, Month_List);
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			finally{
				if(conn != null){
					conn = null;
				}
		//Assert.assertEquals(monthName, Month_List);			
			}
		}
	}