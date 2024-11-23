package Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private DBConnection() {
		// TODO Auto-generated constructor stub
	}
    private static Connection connection;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(DBInfo.dburl, DBInfo.Uname, DBInfo.Upassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    
    
}
