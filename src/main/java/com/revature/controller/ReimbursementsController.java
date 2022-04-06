package com.revature.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.ReimbursementStatuses;
import com.revature.model.Reimbursements;
import com.revature.service.ReimbursementsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/reimbursements"})
public class ReimbursementsController extends HttpServlet {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LogManager.getLogger(ReimbursementsController.class);
    //TODO Create Reimbursement Service
    private static final ReimbursementsService reimbursementsService = new ReimbursementsService();

    //Post reimbursement information to the database
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String JSON = req.getReader().lines().collect(Collectors.joining());
        ReimbursementStatuses reimbursementStatuses = ReimbursementStatuses.valueOf("Pending"); //Automatically statuses show pending
        Reimbursements reimbursements;

        //Marshalling, setting pending, then sending off to be created
        try {
            reimbursements = mapper.readValue(JSON, Reimbursements.class);
            reimbursements.setStatus_id(reimbursementStatuses);
            reimbursementsService.create(reimbursements);
            resp.setStatus(204);

        }
        catch (Exception e) {
            logger.warn(e);
            resp.setStatus(500);
        }
    }

    //Gets the information from the database to send to the front end
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorId = request.getParameter("author_id");
        String role_id = request.getParameter("role_id");
        logger.info(authorId); //Allowing creator to see role and id
        logger.info(role_id);  //if an issue happened

        //Gets the Information for Employees individual accounts
        if(role_id.equals("Employee")) {

            // Gives the employees a list of their reimbursements
            //Marshalls then sends JSON up to database
            List<Reimbursements> reimbursements;
            if (authorId != null) {
                //List<Reimbursements>
                reimbursements = reimbursementsService.getByAuthorId(Integer.parseInt(authorId));
                String JSON = mapper.writeValueAsString(reimbursements);
                response.setContentType("application/json");
                response.setStatus(200);
                response.getOutputStream().println(JSON);
            }

            else {

                try {
                    reimbursements = reimbursementsService.getAll();
                    String JSON = mapper.writeValueAsString(reimbursements);
                    response.setContentType("application/json");
                    response.setStatus(200);
                    response.getOutputStream().println(JSON);

                }
                catch (Exception e) {
                    logger.warn(e);
                }

            }

        }

        //For Finance Managers to view all the records of all the employees
        else{
            List<Reimbursements> reimbursements = reimbursementsService.getAll();
            String JSON = mapper.writeValueAsString(reimbursements);
            response.setContentType("application/json");
            response.setStatus(200);
            response.getOutputStream().println(JSON);
        }
    }
    //Takes the data requested to change and sends it toward the repository to change in the database
    //TODO: Make this functional
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String JSON = req.getReader().lines().collect(Collectors.joining());
        Reimbursements reimbursements;
        ReimbursementStatuses reimbursementStatuses;

        String reimb_id = req.getParameter("reimb_id");
        logger.info(JSON);
        logger.info(reimb_id);


        try {
            reimbursements = mapper.readValue(JSON, Reimbursements.class);
            reimbursements = reimbursementsService.getByReimbursementID(Integer.valueOf(reimb_id));
            logger.info(reimbursements);
            reimbursementsService.updateStatus_ID(reimbursements);
            logger.info(reimbursements);
        } catch (Exception e) {
            logger.warn(e);
        }
    }
}
