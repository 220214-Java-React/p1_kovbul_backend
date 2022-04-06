package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.User;
import com.revature.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    UserService userService = new UserService();
    ObjectMapper mapper = new ObjectMapper();

    // A post method to post information to the data base to make sure the users credentials are valid.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String JSON = req.getReader().lines().collect(Collectors.joining());
        User user = mapper.readValue(JSON, User.class);

        //Validates that the user information is correct
        User dbUser = userService.validate(user);

        //Marshals and sends status upstream for succesful logins
        if(dbUser != null){
            JSON = mapper.writeValueAsString(dbUser);
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getOutputStream().println(JSON);
        }

        //Sets the status for invalid logins
        else{
            resp.setStatus(401);
            resp.getOutputStream().println("Login Incorrect");

        }
    }
}

