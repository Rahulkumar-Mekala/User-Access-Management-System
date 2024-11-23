package Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Manager.DBConnection;

public class UserBeanDAO {

    public int register(UserBean userBean) {
        int result = 0;
        try {
            Connection connection = DBConnection.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(username, password, role, status) VALUES(?, ?, ?, ?)");
            
            preparedStatement.setString(1, userBean.getUsername());
            preparedStatement.setString(2, userBean.getPassword());
            preparedStatement.setString(3, userBean.getRole());
            preparedStatement.setString(4, "Pending");
            
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
    public List<UserBean> getPendingRequests() {
        List<UserBean> pendingUsers = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE status = 'Pending'");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserBean user = new UserBean();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRole(resultSet.getString(4));
                user.setStatus(resultSet.getString(5));
                pendingUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingUsers;

    }
    
    public List<UserBean> getApprovedServet() {
        List<UserBean> pendingUsers = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE status = 'Approved'");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserBean user = new UserBean();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRole(resultSet.getString(4));
                user.setStatus(resultSet.getString(5));
                pendingUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingUsers;

    }
  
    public List<UserBean> getRejectRequestServelt() {
        List<UserBean> pendingUsers = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE status = 'Rejected'");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserBean user = new UserBean();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRole(resultSet.getString(4));
                user.setStatus(resultSet.getString(5));
                pendingUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingUsers;

    }
  
  
    public int updateUserStatus(int userId, String status) {
        int result = 0;
        try {
        	Connection connection = DBConnection.getConnection();
        
            if (connection == null || connection.isClosed()) {
                System.out.println("Connection is closed or invalid.");
                return result;
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET status = ? WHERE id = ?")) {
                preparedStatement.setString(1, status);
                preparedStatement.setInt(2, userId);
                result = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

   
    
}
   

