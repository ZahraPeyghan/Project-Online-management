package com.example.onlinemanagement;

public class TransactionModel {
    private String transactionId,transactionName,transactionAccount,transactionImage,transactionPrice;

    public TransactionModel(String transactionId, String transactionName, String transactionAccount, String transactionImage, String transactionPrice) {
        this.transactionId = transactionId;
        this.transactionName = transactionName;
        this.transactionAccount = transactionAccount;
        this.transactionImage = transactionImage;
        this.transactionPrice = transactionPrice;
    }
    public TransactionModel(){}

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getTransactionAccount() {
        return transactionAccount;
    }

    public void setTransactionAccount(String transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    public String getTransactionImage() {
        return transactionImage;
    }

    public void setTransactionImage(String transactionImage) {
        this.transactionImage = transactionImage;
    }

    public String getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(String transactionPrice) {
        this.transactionPrice = transactionPrice;
    }
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
