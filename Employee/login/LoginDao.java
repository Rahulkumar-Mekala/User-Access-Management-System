package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Register.DBConnection;
import Register.UserBean;

public class LoginDao {
	  UserBean userBean = null;
    public UserBean Login(String username, String password) {
      
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM users WHERE username = ? AND PASSWORD = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userBean = new UserBean();
                userBean.setUsername(resultSet.getString(2)); 
                userBean.setPassword(resultSet.getString(3));
                userBean.setRole(resultSet.getString(4));
                userBean.setStatus(resultSet.getString(5)); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBean;
    }
}
