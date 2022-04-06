package com.revature.repositories;

import com.revature.model.User;
import com.revature.model.UserRoles;
import com.revature.util.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


// implements DAO

public class UserRepository implements DAO<User> {

    // creating user in database

    private static final Logger logger = LogManager.getLogger(UserRepository.class);
    @Override
    public void create(User user) {

            // here we write our SQL to create a user
            Connection connection = null;

            try {
                connection = ConnectionFactory.getConnection();
                //TODO: WIll have to come back in to add role_id
                String sql = "insert into ers_users(username, email, password, first_name, last_name, role_id) values (?, ?, ?, ?, ?, ?)";

                //TODO Create the statement strings.
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getFirstName());
                stmt.setString(5, user.getLastName());
                stmt.setInt(6, user.getUserRoles().ordinal());
                //stmt.setInt(7, user.getRole_ID());

                stmt.executeUpdate();
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            } finally {
                if(connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }



    @Override
    public User getById(int user_id) {

        User user = null;
        String sql = "select * from ers_users where user_id = ?";
        Connection connection;

        try{
            connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, user_id);

            ResultSet resultSet = stmt.executeQuery();;

            if(resultSet.next()){
                user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        UserRoles.values()[resultSet.getInt("role_id")]);
            }
        } catch (Exception e){
            logger.warn(e.getMessage(), e);
        }
        return user;
    }


    public User getByUsername(String username){
        User user = null;
        String sql = "select * from ers_users where username = ?";
        Connection connection;

        try{
            connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet resultSet = stmt.executeQuery();;

            if(resultSet.next()){
                user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        UserRoles.values()[resultSet.getInt("role_id")]);
            }
        } catch (Exception e){
            logger.warn(e.getMessage(), e);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from ers_users";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                users.add(new User(
                                resultSet.getInt("user_id"),
                                resultSet.getString("username"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                UserRoles.values()[resultSet.getInt("role_id")]));
            }


        } catch (Exception e) {
            logger.warn(e);
        }
        return users;
    }


        @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {

    }
}
