package com.revature.repositories;

import com.revature.model.ReimbursementStatuses;
import com.revature.model.ReimbursementTypes;
import com.revature.model.Reimbursements;
import com.revature.util.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Repository for reimbursements to connect to the database
public class ReimbursementsRepository implements DAO<Reimbursements>{
    //Logger to log information
    private static final Logger logger = LogManager.getLogger(UserRepository.class);

    //Create class for the user to create reimbursements
    @Override
    public void create(Reimbursements reimbursements) {
        Connection connection = null;

        //Connection to connect to the database to store the information asked for in the stmt
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

        //Selects a particular users reimbursements by their user id
        public List<Reimbursements> getByAuthorId(int author_id){
            List<Reimbursements> reimbursements = new ArrayList<>();

            //Connects to the database and retrieves information asked by the sql by author Id
            try(Connection connection = ConnectionFactory.getConnection()){
                String sql = "select * from ers_reimbursements where author_id = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setInt(1, author_id);

                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    reimbursements.add(
                        new Reimbursements(
                                rs.getInt("reimb_id"),
                                rs.getDouble("amount"),
                                rs.getTimestamp("submitted"),
                                rs.getTimestamp("resolved"),
                                rs.getString("description"),
                                rs.getInt("payment_id"),
                                rs.getInt("author_id"),
                                ReimbursementStatuses.values()[rs.getInt("status_id")],
                                ReimbursementTypes.values()[rs.getInt("type_id")]));


            }
        }catch (Exception e){
            logger.warn(e.getMessage(), e);
        }
        return reimbursements;

    }
    //Gets by the reimbursement ID number of a particular reimbursement request
    //Used to then update the status of that request
    public Reimbursements getByReimbursementID(int reimb_id){
        Reimbursements reimbursements = null;
        logger.info(reimbursements);
        try{
            Connection connection = ConnectionFactory.getConnection();
            String sql = "select * from ers_reimbursements where reimb_id = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            logger.info(stmt);
            stmt.setInt(1, reimb_id);

            ResultSet rs = stmt.executeQuery();
            logger.info(rs);

            if (rs.next()){
                reimbursements =
                        new Reimbursements(
                                rs.getInt("reimb_id"),
                                rs.getDouble("amount"),
                                rs.getTimestamp("submitted"),
                                rs.getTimestamp("resolved"),
                                rs.getString("description"),
                                rs.getInt("payment_id"),
                                rs.getInt("author_id"),
                                ReimbursementStatuses.values()[rs.getInt("status_id")],
                                ReimbursementTypes.values()[rs.getInt("type_id")]);


            }
            logger.info(reimbursements);
        }catch (Exception e){
            logger.warn(e.getMessage(), e);
        }
        return reimbursements;

    }

    @Override
    //Gets all the reimbursements requests, used for finance manager to view all
    public List<Reimbursements> getAll() {
        List<Reimbursements> reimbursements = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from ers_reimbursements";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                reimbursements.add(new Reimbursements(
                        resultSet.getInt("reimb_id"),
                        resultSet.getDouble("amount"),
                        resultSet.getTimestamp("submitted"),
                        resultSet.getTimestamp("resolved"),
                        resultSet.getString("description"),
                        resultSet.getInt("payment_id"),
                        resultSet.getInt("author_id"),
                        ReimbursementStatuses.values()[resultSet.getInt("status_id")],
                        ReimbursementTypes.values()[resultSet.getInt("type_id")]));
            }


        } catch (Exception e) {
            logger.warn(e);
        }
        return reimbursements;



    }

    @Override
    //Updates the status id depending on the reimbursement ID
    public void update(Reimbursements reimbursements) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "update ers_reimbursements set status_id = ? where reimb_id = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, reimbursements.getStatus_id().ordinal());
            stmt.setInt(2, reimbursements.getReimb_id());

            stmt.executeUpdate();


        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
    }

        @Override
    public void deleteById(int id) {

    }
}
