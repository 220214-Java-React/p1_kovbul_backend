package com.revature.repositories;

import com.revature.model.User;
import com.revature.util.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserRepository implements DAO<User> {
    private static final Logger logger = LogManager.getLogger(UserRepository.class);
    @Override
    public void create(User user) {

            // here we write our SQL to create a user
            Connection connection = null;

            try {
                connection = ConnectionFactory.getConnection();
                String sql = "insert into ERS_USERS(username, email, password, first_name, last_name) values (?, ?, ?, ?, ?)";

                //TODO Create the statement strings.
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, );
                stmt.setString(2, );

                stmt.executeUpdate();
            } catch (SQLException e) {
                logger.warn(e.getMessage(), e);
            } finally {
                if(connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }



    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {

    }
}
