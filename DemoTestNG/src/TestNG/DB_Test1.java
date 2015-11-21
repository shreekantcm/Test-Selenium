package TestNG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DB_Test1 {

	public static void main(String[] args) {

		Connection conn = null;
		
		String url = "jdbc:mysql://127.0.0.1:3306/";
		String databaseName = "my_db";
		String username = "root";
		String password = "root";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url+databaseName, username, password);
			
			String sqlQuerry = "SELECT * FROM my_db.month";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlQuerry);
			
			ArrayList<String> monthID = new ArrayList<String>();
			ArrayList<String> Month_Name = new ArrayList<String>();
			
			while(result.next()){
				//System.out.print(result.getString(1));
				monthID.add(result.getString(1));
				//System.out.print("\t" + result.getString(2));
				Month_Name.add(result.getString(2));
		     }
			//return Month_Name;
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			if(conn != null){
				conn = null;
			}
		}

	}

}
