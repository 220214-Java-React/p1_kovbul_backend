package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.User;
import com.revature.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

public class UserController extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(UserController.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final UserService userService = new UserService();

    //Gets a list of the users and the user information they provided
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String JSON;
        String username = request.getParameter("username");

        //Validating username is not null
        if (username != null) {

            //Getting the user information by the username
            User user = userService.getByUsername(username);
            JSON = mapper.writeValueAsString(user);
            response.setContentType("application/json");
            response.setStatus(200);
            response.getOutputStream().println(JSON);
        }
        // Getting the list of all the users and user information
        else {

            List<User> users = userService.getAll();
            try {
                JSON = mapper.writeValueAsString(users);

                response.setContentType("application/json");
                response.setStatus(200);
                response.getOutputStream().println(JSON);

            } catch (Exception e) {
                logger.warn(e);
            }
        }
    }






    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String JSON = req.getReader().lines().collect(Collectors.joining());
        User user;

        try {
            user = mapper.readValue(JSON, User.class);
            userService.create(user);

            resp.setStatus(204);

        } catch (Exception e) {
            logger.warn(e);
            resp.setStatus(500);
        }




    }
}
