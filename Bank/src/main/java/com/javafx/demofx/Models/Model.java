package com.javafx.demofx.Models;

import com.javafx.demofx.Views.AccountType;
import com.javafx.demofx.Views.ViewFactory;
import javafx.beans.property.ReadOnlySetProperty;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CLIENT;

    /* Client Data Section */
    private final Client client;
    private boolean clientLoginSuccessFlag;
    /* Admin Data Section */

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // Client Data Section
        this.clientLoginSuccessFlag = false;
        this.client = new Client("","","",null, null, null);
        // Admin Data Section
    }
    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public DatabaseDriver getDatabaseDriver() { return databaseDriver; }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    /* Client Method Section */
    public boolean getClientSuccessFlag() { return this.clientLoginSuccessFlag; }
    public void setClientLoginSuccessFlag(boolean flag) {this.clientLoginSuccessFlag = flag; }

    public Client getClient() {
        return client;
    }
    public void evaluateClientCred(String pAddress, String password) {
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try {
            if(resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                    this.client.lastNameProperty().set(resultSet.getString("LastName"));
                    this.client.pAddressProperty().set(resultSet.getString("PayeeAddress"));
                    String[] dateParts = resultSet.getString("Date").split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                    this.client.dateProperty().set(date);
                    //checkingAccount = null;
                    //savingsAccount = null;
                    this.clientLoginSuccessFlag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
