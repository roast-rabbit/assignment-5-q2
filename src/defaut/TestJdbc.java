package defaut;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/q2";
		String user = "postgres";
		String pass = "root";
		// TODO Auto-generated method stub
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Successful!!!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
