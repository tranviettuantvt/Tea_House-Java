package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tea_house_prj301","root","2230011123");
			System.out.print("connected");
		}
		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DbCon a=new DbCon();
		a.getConnection();
	}
}