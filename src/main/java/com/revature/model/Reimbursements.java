package com.revature.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reimbursements implements Serializable {

    private Integer reimb_id;
    private Double amount;
    private Timestamp submitted;
    private Timestamp resolved;
    private String description;
    private Integer payment_id;
    private Integer author_id;
    private ReimbursementStatuses status_id;
    private ReimbursementTypes type_id;

    // empty reimbursement constructor

    public Reimbursements(){

    }


    // reimbursement constructor with reimb, amount, timestamp sub and res, description, payment id, author id, status id, type id

    public Reimbursements(Integer reimb_id, Double amount, Timestamp submitted, Timestamp resolved, String description, Integer payment_id, Integer author_id, ReimbursementStatuses status_id, ReimbursementTypes type_id) {
        this.reimb_id = reimb_id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.payment_id = payment_id;
        this.author_id = author_id;
        this.status_id = status_id;
        this.type_id = type_id;

    }

    // reimbursement constructor same as above but without reimb id

    public Reimbursements(Double amount, Timestamp submitted, Timestamp resolved, String description, Integer payment_id, Integer author_id, ReimbursementStatuses status_id, ReimbursementTypes type_id) {
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.payment_id = payment_id;
        this.author_id = author_id;
        this.status_id = status_id;
        this.type_id = type_id;


    }

    // constructor for enum reimbursement statuses

    public Reimbursements(ReimbursementStatuses status_id) {
        this.status_id = status_id;
    }

    // constructor with reimb- id and status id

    public Reimbursements(Integer reimb_id, ReimbursementStatuses status_id) {
        this.reimb_id = reimb_id;
        this.status_id = status_id;
    }

    // constructor with amount, submitted, description, author_id, status id, type id
    public Reimbursements(Double amount, Timestamp submitted, String description, Integer author_id, ReimbursementStatuses status_id, ReimbursementTypes type_id) {
        this.amount = amount;
        this.submitted = submitted;
        this.description = description;
        this.author_id = author_id;
        this.status_id = status_id;
        this.type_id = type_id;
    }

//    public Reimbursements(int reimb_id, double amount, Timestamp submitted, Timestamp resolved, String description, int payment_id, int author_id, int resolver_id, int status_id, int type_id) {
//    }


    public Integer getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(Integer reimb_id) {
        this.reimb_id = reimb_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




//    public String getReceipt() {
//        return receipt;
//    }
//
//    public void setReceipt(String receipt) {
//        this.receipt = receipt;
//    }


    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }


    public ReimbursementStatuses getStatus_id() {
        return status_id;
    }

    public void setStatus_id(ReimbursementStatuses status_id) {
        this.status_id = status_id;
    }

    public ReimbursementTypes getType_id() {
        return type_id;
    }

    public void setType_id(ReimbursementTypes type_id) {
        this.type_id = type_id;
    }
}
