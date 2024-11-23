package updateEditServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Manager.DBConnection;
import Manager.ManagerBean;


public class AdminUpdateDao {
    public int k = 0;

    public int update(ManagerBean managerBean) {
        try {
            Connection connection = DBConnection.getConnection();
           
            PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE users SET USERNAME = ?, PASSWORD = ?, ROLE = ?, STATUS = ? WHERE USERNAME = ?"
            );
            preparedStatement.setString(1, managerBean.getUsername());
            preparedStatement.setString(2, managerBean.getPassword());
            preparedStatement.setString(3, managerBean.getRole());
            preparedStatement.setString(4, managerBean.getStatus());
            preparedStatement.setString(5, managerBean.getUsername());

            k = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
