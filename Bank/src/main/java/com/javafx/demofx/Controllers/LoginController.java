package com.javafx.demofx.Controllers;

import com.javafx.demofx.Models.Model;
import com.javafx.demofx.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public Label payee_address_lbl;
    public TextField payee_address_fid;
    public TextField password_fid;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue()));
        login_btn.setOnAction(event -> onLogin());
    }
    private void onLogin() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT) {
            //Model.getInstance().getViewFactory().showClientWindow();
            // Evaluate Client Login Credentials
            Model.getInstance().evaluateClientCred(payee_address_fid.getText(), password_fid.getText());
            if (Model.getInstance().getClientSuccessFlag()) {
                // Close the Login Stage
                Model.getInstance().getViewFactory().closeStage(stage);
                // Open the Client Window
                Model.getInstance().getViewFactory().showClientWindow();
            } else {
                payee_address_fid.setText("");
                password_fid.setText("");
                error_lbl.setText("No Such Login Credentials.");
            }
        } else {
            Model.getInstance().getViewFactory().showAdminWindow();
        }
    }
}
