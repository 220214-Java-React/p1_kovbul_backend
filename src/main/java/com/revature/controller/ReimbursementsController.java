package com.revature.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/reimbursements"})
public class ReimbursementsController extends HttpServlet {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LogManager.getLogger(ReimbursementsController.class);
    //TODO Create Reimbursement Service
    private static final ReimbursementsService reimbursementsService = new ReimbursementsService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String JSON = req.getReader().lines().collect(Collectors.joining());

        try {
            Reimbursements reimbursements = mapper.readValue(JSON, Reimbursements.class);

            //TODO Create reimbursementService
            reimbursementsService.create(reimbursements);

        } catch (Exception e) {
            logger.warn(e);
        }
    }
}
