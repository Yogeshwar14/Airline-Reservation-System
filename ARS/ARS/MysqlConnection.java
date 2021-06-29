package ARS;

import java.sql.Connection;
import java.sql.DriverManager;


public class MysqlConnection
{
	public static Connection getconnection() throws Exception{
		String dbRoot = "jdbc:mysql://";
		String hostname = "localhost:3306/";
		String dbname = "ars1";						
		String dbUrl = dbRoot + hostname + dbname;
		
		String hostUsername = "root";
		String hostPassword = "ysdsyd@321";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection myconn = (Connection)DriverManager.getConnection(dbUrl, hostUsername, hostPassword);
		
		return myconn;
	}
}