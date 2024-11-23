package updateViewAllDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import AdminLogin.DBconnection;
import Manager.ManagerBean;
import jakarta.servlet.RequestDispatcher;

public class updateviewAllDetails {
 public ArrayList<ManagerBean>managerBeans = new ArrayList<ManagerBean>();
  public ArrayList<ManagerBean>retrieve(){
	  
	  try {
		  Connection connection = DBconnection.getcon();
		  PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
		  ResultSet resultSet = preparedStatement.executeQuery();
		   while (resultSet.next()) {
			   ManagerBean bean = new ManagerBean();
			   bean.setId(resultSet.getInt(1));
			  bean.setUsername(resultSet.getString(2));
			  bean.setPassword(resultSet.getString(3));
			  bean.setRole(resultSet.getString(4));
			  bean.setStatus(resultSet.getString(5));
			 
			  managerBeans.add(bean);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return managerBeans;
  }
  
}

