package com.revature.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.revature.model.User;
import com.revature.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserService {
    private static User currentUser;
    private final Logger logger;
    private final UserRepository userRepository;
    private final BCrypt.Hasher hasher;
    private final String SALT = "xEZew5rGNU?tyoF.";

    public UserService() {
        this.userRepository = new UserRepository();
        this.logger = LogManager.getLogger(UserService.class);
        this.hasher = BCrypt.withDefaults();
    }


    public void create(User user) {
//        String encryptedPass = encryptPassword(user.getPassword());
//        user.setPassword(encryptedPass);
        userRepository.create(user);
    }

    //ToDO Play around with this and get a list from database

    public List<User> getAll() {
        return userRepository.getAll();
    }


    public User validate(User user) {
        User dbUser = userRepository.getByUsername(user.getUsername());

        //TODO: Add encryption to this
        if (dbUser != null) {
            if (dbUser.getPassword().equals((user.getPassword()))) {
                currentUser = dbUser;
                return dbUser;
            }

        }
        return null;
    }


    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }


//    private String encryptPassword(String password) {
//        return new String(
//                hasher.hash(4, SALT.getBytes(StandardCharsets.UTF_8),
//                        password.getBytes(StandardCharsets.UTF_8)),
//                StandardCharsets.UTF_8);
//    }

}


