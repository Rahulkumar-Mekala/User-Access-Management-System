package AdminLogin;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	public static Connection connection ;
	private DBconnection() {
		// TODO Auto-generated constructor stub
	}
	static {
		
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		 connection = DriverManager.getConnection(DBinfo.dburl,DBinfo.Uname,DBinfo.Upassword);
	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public static Connection getcon() {
		return connection;
		
	}

}


