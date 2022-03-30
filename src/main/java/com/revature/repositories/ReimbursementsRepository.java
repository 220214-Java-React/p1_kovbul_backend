package com.revature.repositories;

import com.revature.model.Reimbursements;
import com.revature.util.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementsRepository implements DAO<Reimbursements>{
    private static final Logger logger = LogManager.getLogger(UserRepository.class);
    @Override
    public void create(Reimbursements reimbursements) {
        Connection connection = null;

        try{
            connection = ConnectionFactory.getConnection();

            String sql = "insert into ers_reimbursements(amount, submitted, resolved, description, payment_id, author_id, status_id, type_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setDouble(1, reimbursements.getAmount());
            stmt.setTimestamp(2, reimbursements.getSubmitted());
            stmt.setTimestamp(3, reimbursements.getResolved());
            stmt.setString(4, reimbursements.getDescription());
            stmt.setInt(5, reimbursements.getPayment_id());
            stmt.setInt(6, reimbursements.getAuthor_id());
//            stmt.setInt(7, reimbursements.getResolver_id());
            stmt.setInt(7, reimbursements.getStatus_id().ordinal());
            stmt.setInt(8, reimbursements.getType_id().ordinal());

            stmt.executeUpdate();

        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }

        }

        @Override
    public Reimbursements getById(int id) {
        return null;
    }

    @Override
    public List<Reimbursements> getAll() {
        return null;
    }

    @Override
    public void update(Reimbursements reimbursements) {

    }

    @Override
    public void deleteById(int id) {

    }
}
