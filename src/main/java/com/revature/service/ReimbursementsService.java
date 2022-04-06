package com.revature.service;

import com.revature.model.Reimbursements;
import com.revature.repositories.ReimbursementsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

// connecting getters and setters to communicate with controllers and repositories

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

    public List<Reimbursements> getByAuthorId(int parseInt) {
        return reimbursementsRepository.getByAuthorId(parseInt);

    }

    public void updateStatus_ID(Reimbursements reimbursements) {
        reimbursementsRepository.update(reimbursements);
    }

    public Reimbursements getByReimbursementID(Integer reimb_id) {
        logger.info(reimb_id);
        return reimbursementsRepository.getByReimbursementID(reimb_id);
    }
}
