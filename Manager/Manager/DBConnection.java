package Manager;

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
            connection = DriverManager.getConnection(DBInfo.DB_URL, DBInfo.DB_USERNAME, DBInfo.DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    
    
}
