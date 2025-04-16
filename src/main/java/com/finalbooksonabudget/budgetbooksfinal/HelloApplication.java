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
    public void start(Stage stage) throws IOException { //start method prepares all the launch elements
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml")); //establishes a home screen
        Scene scene = new Scene(fxmlLoader.load(), 600, 395); //sets the windows initial dimensions
        stage.setTitle("Books on a Budget"); //name of the frame
        stage.setScene(scene); //sets the scene for the stage
        stage.getIcons().add(new Image("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\BooksOnABudget_Logo.png")); //changes the icon to the books on a budget logo

        stage.setResizable(false); //locks the window size
        stage.show(); //makes the stage visible


    }





    public static void main(String[] args) throws FileNotFoundException { //main method to run other methods

        launch(); //Launches the Application
    }
}