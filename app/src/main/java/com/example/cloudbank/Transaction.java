package com.example.cloudbank;

import java.util.Date;

public class Transaction {

    private Integer imageID_transaction;
    private String name_transaction;//is the type of the transaction
    private String montant_trsaction;
    private String date_transaction;// we could use date here / SimpleDateFormat sdfSource = new SimpleDateFormat("dd-MM-yy");
    // Date date = sdfSource.parse(strDate);

    public Transaction(Integer imageID_transaction, String name_transaction, String montant_trsaction, String date_transaction) {
        this.imageID_transaction = imageID_transaction;
        this.name_transaction = name_transaction;
        this.montant_trsaction = montant_trsaction;
        this.date_transaction = date_transaction;
    }

    public Integer getImageID_transaction() {
        return imageID_transaction;
    }

    public String getName_transaction() {
        return name_transaction;
    }

    public String getMontant_trsaction() {
        return montant_trsaction;
    }

    public String getDate_transaction() {
        return date_transaction;
    }

    public void setImageID_transaction(Integer imageID_transaction) {
        this.imageID_transaction = imageID_transaction;
    }

    public void setName_transaction(String name_transaction) {
        this.name_transaction = name_transaction;
    }

    public void setMontant_trsaction(String montant_trsaction) {
        this.montant_trsaction = montant_trsaction;
    }

    public void setDate_transaction(String date_transaction) {
        this.date_transaction = date_transaction;
    }
}
