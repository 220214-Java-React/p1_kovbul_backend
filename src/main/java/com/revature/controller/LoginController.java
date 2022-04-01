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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String JSON = req.getReader().lines().collect(Collectors.joining());
        User user = mapper.readValue(JSON, User.class);

        User dbUser = userService.validate(user);

        if(dbUser != null){
            JSON = mapper.writeValueAsString(dbUser);
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getOutputStream().println(JSON);

        }else{
            resp.setStatus(401);
            resp.getOutputStream().println("Login Incorrect");

        }
    }
}

