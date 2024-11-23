package Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import AdminLogin.DBconnection;
import Manager.ManagerBean;

public class AdminLoginDAO {
	public ManagerBean managerBean = null;
	public ManagerBean Login(String email,String Password) {
		try {
			Connection connection = DBconnection.getcon();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from manager_page where USERNAME=? and PASSWORD =?");
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, Password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				managerBean = new ManagerBean();
				managerBean.setUsername(resultSet.getString(2));
				managerBean.setPassword(resultSet.getString(3));
				managerBean.setRole(resultSet.getString(4));
			}
		} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
		}
		return managerBean;
	}

}
