package com.revature.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.revature.model.User;
import com.revature.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class UserService {
    private final Logger logger;
    private final UserRepository userRepository;
    private final BCrypt.Hasher hasher;

    public UserService() {
        this.userRepository = new UserRepository();
        this.logger = LogManager.getLogger(UserService.class);
        this.hasher = BCrypt.withDefaults();
    }


    public void create(User user) {

        //going to need to encrypt password in here
//        String encryptedPass = encryptPassword(user.getPassword());
//        user.setPassword(encryptedPass);

        userRepository.create(user);
    }

    //ToDO Play around with this and get a list from database

    public List<User> getAll() {
        return userRepository.getAll();
    }

//    private String getUsername() {
//        String username = "";
//        boolean valid = false;
//
//        while (!valid) {
//            System.out.print("Username: ");
//            username = scanner.nextLine();
//
//            TODO: Username validation
//            if (username.length() > 4) {
//                valid = true;
//            } else {
//                System.out.println("Username must be longer than 4 characters.");
//            }
//        }
//        return username;
//    }
//
//    private String getPassword(){
//        String password = "";
//        boolean valid = false;
//
//        while(!valid){
//            System.out.print("Password: ");
//            password = scanner.nextLine();
//
//            TODO: Password validation
//            if(password.length() > 4){
//                valid = true;
//            } else{
//                System.out.println("Password must be longer than 4 characters.");
//            }
//        }
//        return encryptPassword(password);
//    }
//
    private String encryptPassword(String password){
        return hasher.hashToString(4, password.toCharArray());
    }

}



