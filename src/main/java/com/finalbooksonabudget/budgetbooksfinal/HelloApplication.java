package com.finalbooksonabudget.budgetbooksfinal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.Icon;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 395);
        stage.setTitle("Books on a Budget");
        stage.setScene(scene);
        stage.getIcons().add(new Image("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\BooksOnABudget_Logo.png"));

        stage.setResizable(false);
        stage.show();


    }





    public static void main(String[] args) throws FileNotFoundException {

        launch();
    }
}