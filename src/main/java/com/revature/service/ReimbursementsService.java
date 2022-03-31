package com.revature.service;

import com.revature.model.Reimbursements;
import com.revature.repositories.ReimbursementsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ReimbursementsService {
    private final Logger logger;
    private final ReimbursementsRepository reimbursementsRepository;

    public ReimbursementsService(){
        this.logger = LogManager.getLogger(ReimbursementsService.class);
        this.reimbursementsRepository = new ReimbursementsRepository();
    }

    public void create(Reimbursements reimbursements) {
        reimbursementsRepository.create(reimbursements);
    }

    public List<Reimbursements> getAll() {
        return reimbursementsRepository.getAll();}
}
