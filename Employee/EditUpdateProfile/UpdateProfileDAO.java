package EditUpdateProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Register.UserBean;

public class UpdateProfileDAO {
    public int update(UserBean bean) {
        int result = 0;
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET USERNAME = ? , password =? where username=?");
            preparedStatement.setString(1, bean.getUsername());
             preparedStatement.setString(2,bean.getPassword());
             preparedStatement.setString(3, bean.getUsername());
             
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
