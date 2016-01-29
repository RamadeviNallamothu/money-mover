package com.pivotal.brighton.dto;

import org.springframework.data.repository.query.Param;

/**
 * Created by pivotal on 1/29/16.
 */
public class TransferRequestDTO {

    private String sourceAccountID;
    private String destinationAccountID;
    private double transactionAmount;
    private String transactionNotes;

    public String getSourceAccountID() {
        return sourceAccountID;
    }

    public void setSourceAccountID(String sourceAccountID) {
        this.sourceAccountID = sourceAccountID;
    }

    public String getDestinationAccountID() {
        return destinationAccountID;
    }

    public void setDestinationAccountID(String destinationAccountID) {
        this.destinationAccountID = destinationAccountID;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionNotes() {
        return transactionNotes;
    }

    public void setTransactionNotes(String transactionNotes) {
        this.transactionNotes = transactionNotes;
    }
}
