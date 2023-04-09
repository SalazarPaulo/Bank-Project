package com.javafx.demofx;

import com.javafx.demofx.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
