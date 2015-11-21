package Demo;

import java.sql.*;
import java.util.ArrayList;

//mysql-connector-java-5.1.23-bin


public class DB_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			//ArrayList<String> FirstName = new ArrayList<String>();
			//ArrayList<String> Address = new ArrayList<String>();
			//ArrayList<String> City = new ArrayList<String>();
			
			while(result.next()){
				//System.out.print(result.getString(1));
				monthID.add(result.getString(1));
				//System.out.print("\t" + result.getString(2));
				monthName.add(result.getString(2));
				//System.out.print("\t" + result.getString(3));
				//FirstName.add(result.getString(3));
				//System.out.println("\t" + result.getString(4));	
				//Address.add(result.getString(4));
				//System.out.println("\t" + result.getString(5));	
				//City.add(result.getString(5));
		     }
			
			System.out.println(monthName);
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
