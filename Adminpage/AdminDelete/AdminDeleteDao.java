package AdminDelete;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Manager.DBConnection;
import Manager.ManagerBean;

public class AdminDeleteDao {
	 public int k=0;
	 public int Delete(ManagerBean managerBean) {
		 try {
			 Connection connection = DBConnection.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("delete from users  where USERNAME= ? and PASSWORD=?");
			 
			 preparedStatement.setString(1, managerBean.getUsername());
			 preparedStatement.setString(2,managerBean.getPassword());
			  k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		return k;
		 
		
	}
	  
		
		
}
