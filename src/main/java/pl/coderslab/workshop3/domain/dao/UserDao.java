package pl.coderslab.workshop3.domain.dao;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.workshop3.domain.helpers.DBUtil;
import pl.coderslab.workshop3.domain.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";

    public static User createUser(User user){

        try (Connection conn = DBUtil.connect();
             PreparedStatement statement = conn.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            statement.setString( 1, user.getUserName());
            statement.setString( 2, user.getEmail());
            statement.setString( 3, hashPassword(user.getPassword()));
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getInt(1));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static User read(int userId){
        try (Connection conn = DBUtil.connect()){
             PreparedStatement statement = conn.prepareStatement(READ_USER_QUERY);
             statement.setInt(1, userId);
             ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static int deleteUser(int userID){

        try (Connection conn = DBUtil.connect();
             PreparedStatement statement = conn.prepareStatement(DELETE_QUERY))
        {
            statement.setInt(1,userID);
            return statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static User updateUser(User user){
        try (Connection conn = DBUtil.connect();
             PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY))
        {
            statement.setString( 1, user.getUserName());
            statement.setString( 2, user.getEmail());
            statement.setString( 3, hashPassword(user.getPassword()));
            statement.setInt(4,user.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return user;
    }


    public static List<User> readAll() {


        try (Connection conn = DBUtil.connect()){
            List<User> users = new ArrayList<>();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }



}
