package com.finalbooksonabudget.budgetbooksfinal;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class projectController {


    @FXML
    protected void gotofilterSearch() {
    }

    @FXML
    public void showThrift() throws FileNotFoundException { //This method displays the Thrift books catalog in the text Area
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));
        //The above code read from the thrift books txt file using the scanner

        List<String> listofbooksThrift = new ArrayList<String>(); //The List Array that stores all of the book titles from thrift books
        String catalogtitles; // a variable that will hold the next Line input
        int i = 0; //initializing the variable i
        while (scnr.hasNextLine()) { //while loop to add the book titles to the array
            catalogtitles = scnr.nextLine(); //reads the next line into the variable catalogtitles
            listofbooksThrift.add(catalogtitles); //adds the book to the Array List

            i++; //iterates i

        }
        for (i = 0; i < listofbooksThrift.size(); i += 2) { //this for loop allows me to check each individual value of the Array List
            System.out.println(listofbooksThrift.get(i)); //gets the numeric value of i for each item in the list
            CatalogArea.setWrapText(true); //prevents horizontal scrolling
            CatalogArea.setText(String.valueOf(listofbooksThrift)); //prints the whole List Array to the TextArea on Catalogpage.fxml
        }
    }

    @FXML
    public void showEbay() throws IOException { //Displays the catalog items for the Ebay txt file
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));
        //reads the file using the scanner class

        List<String> listofbooksEbay = new ArrayList<String>(); //creates an array list to put the contents of the file into
        String catalogtitles; //initializes a string variable catalogtitles
        int i = 0; //initializes the variable i
        while (scnr.hasNextLine()) { //reads each line of the file until the end of the file
            catalogtitles = scnr.nextLine(); //puts the input from the next Line into the variable catalogtitles
            listofbooksEbay.add(catalogtitles); //adds the book titles to the Ebay list

            i++; //iterates i

        }
        for (i = 0; i < listofbooksEbay.size(); i += 2) { //the for loop allows me to check each iteration in the Ebay list
            System.out.println(listofbooksEbay.get(i)); //prints out the next iteration of i (I wanted dto check the titles only, so that's why you see i+=2 instead of i++
            CatalogArea.setWrapText(true); //prevents horizontal scrolling in the TextArea
            CatalogArea.setText(String.valueOf(listofbooksEbay)); //Prints the whole Ebay catalog to the Text Area
        }

    }

    @FXML
    private TextArea CatalogArea; //initializes an fx:id from Catalogpage.fxml

    @FXML
    public void showAbe() throws IOException { //method for displaying the abe books catalog on the catalogpage.fxml


        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));
        //scanner class to read the file

        List<String> listofbooksAbe = new ArrayList<String>(); //creates a new List Array to put the booktitle of abe books in
        String catalogtitles; //initializes catalogtitles
        int i = 0; //initializes i at 0
        while (scnr.hasNextLine()) { //a loop that constantly scans for the next line in the txt file
            catalogtitles = scnr.nextLine(); //scans the next line into the variable
            listofbooksAbe.add(catalogtitles); //adds the next Line into the Array List

            i++; //iterates i

        }
        for (i = 0; i < listofbooksAbe.size(); i += 2) { // for loop that will iterate i so that I can print the book title names
            System.out.println(listofbooksAbe.get(i)); //prints the next iteration of an element in the Array List
            CatalogArea.setWrapText(true); //prevents horizontal scrolling
            CatalogArea.setText(String.valueOf(listofbooksAbe)); //prints the Array List to the Text Area
        }

    }


    @FXML
    protected void detectTen() throws IOException{ //filters the Array lists by price of between 10 and five dollars
        List<Double> finalListprice = new ArrayList<Double>();  // The code below and to the side initializes the Array lists that I wil need to store and compare everything
        List<String> finalListtitle = new ArrayList<String>();
        List<String> listOfAbe = new ArrayList<String>();
        List<String> listOfThrift = new ArrayList<String>();
        List<String> listOfEbay = new ArrayList<String>(); //below are teh files that I will scan from
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));
        Scanner scnr2 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));
        Scanner scnr3 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));
        String catalogContent; //variable to hold the next Line content
        String catalogContent2; //variable to hold the next Line content

        int i;
        try{
            while(scnr.hasNextLine()) {
                catalogContent = scnr.nextLine();
                listOfAbe.add(catalogContent); //Fills the Abe books Array list
            }

            //the following code uses a for loop and if statement to filter and check if an iteration of The Array List is between the proper range of numbers, if so, they get added to the final Array list
            for (i = 1; i <= listOfAbe.size(); i += 2) {
                double parsedlistDouble = Double.parseDouble(listOfAbe.get(i)); //parsing the list Elements allows them to be compared at a numerical level
                if((parsedlistDouble <= 10.00) && (parsedlistDouble > 5.00)){
                    finalListprice.add(parsedlistDouble);
                }
                parsedlistDouble = Double.parseDouble(listOfAbe.get(i));


            }


            while (scnr2.hasNextLine()) {
                catalogContent2 = scnr2.nextLine();
                listOfThrift.add(catalogContent2); //Fills the Thrift books Array list
            }
            //the following code uses a for loop and if statement to filter and check if an iteration of The Array List is between the proper range of numbers, if so, they get added to the final Array list
            for (i = 1; i < listOfThrift.size(); i += 2) {
                double parsedlistDouble2 = Double.parseDouble(listOfThrift.get(i)); //parsing the list Elements allows them to be compared at a numerical level
                if ((parsedlistDouble2 <= 10.00) && (parsedlistDouble2 > 5.00)) {
                    finalListprice.add(parsedlistDouble2);
                }
                parsedlistDouble2 = Double.parseDouble(listOfThrift.get(i));

            }

            while (scnr3.hasNextLine()) {
                String catalogContent3 = scnr3.nextLine();
                listOfEbay.add(catalogContent3); //Fills the Ebay books Array list
            }
            // //the following code uses a for loop and if statement to filter and check if an iteration of The Array List is between the proper range of numbers, if so, they get added to the final Array list
            for (i = 1; i < listOfThrift.size(); i += 2) {
                double parsedlistDouble3 = Double.parseDouble(listOfEbay.get(i));
                if ((parsedlistDouble3 <= 10.00) && (parsedlistDouble3 > 5.00)) {
                    finalListprice.add(parsedlistDouble3);
                }
                parsedlistDouble3 = Double.parseDouble(listOfEbay.get(i)); //parsing the list Elements allows them to be compared at a numerical level

            }
        }catch (NoSuchElementException b){ //checks for exceptions

        }
        filterList.setWrapText(true); //stops the TextArea from having Horizontal scroll
        filterList2.setWrapText(true); //stops the TextArea from having Horizontal scroll
        filterList.setText(String.valueOf(finalListprice)); //prints out the Final filtered Array List that sources from all of the other lists
        filterList2.setText(String.valueOf(("check the catalog for book names that match the prices (order of prices: Abe, Thrift, Ebay)"))); //Prints an instructional text to the TextArea
    }

    @FXML
    private TextArea filterList; //initializes an fx:id element
    @FXML
    private TextArea filterList2; //initializes an fx:id element


    //NOTE: the following code block follows the same annotations as detect10()
    @FXML
    public void detectFive(ActionEvent event) throws FileNotFoundException  {
        List<Double> finalListprice = new ArrayList<Double>();
        List<String> finalListtitle = new ArrayList<String>();
        List<String> listOfAbe = new ArrayList<String>();
        List<String> listOfThrift = new ArrayList<String>();
        List<String> listOfEbay = new ArrayList<String>();
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));
        Scanner scnr2 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));
        Scanner scnr3 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));
        String catalogContent;
        String catalogContent2;

        int i;
try{
            while(scnr.hasNextLine()) {
            catalogContent = scnr.nextLine();
            listOfAbe.add(catalogContent);
            }

            for (i = 1; i <= listOfAbe.size(); i += 2) {
                double parsedlistDouble = Double.parseDouble(listOfAbe.get(i));
                if(parsedlistDouble <= 5.00) {
                    finalListprice.add(parsedlistDouble);
                }
                parsedlistDouble = Double.parseDouble(listOfAbe.get(i));


            }


            while (scnr2.hasNextLine()) {
                    catalogContent2 = scnr2.nextLine();
                    listOfThrift.add(catalogContent2);
                }

                for (i = 1; i < listOfThrift.size(); i += 2) {
                    double parsedlistDouble2 = Double.parseDouble(listOfThrift.get(i));
                    if (parsedlistDouble2 <= 5.00) {
                        finalListprice.add(parsedlistDouble2);
                    }
                    parsedlistDouble2 = Double.parseDouble(listOfThrift.get(i));

                }

        while (scnr3.hasNextLine()) {
            String catalogContent3 = scnr3.nextLine();
            listOfEbay.add(catalogContent3);
        }

         for (i = 1; i < listOfThrift.size(); i += 2) {
            double parsedlistDouble3 = Double.parseDouble(listOfEbay.get(i));
            if (parsedlistDouble3 <= 5.00) {
                finalListprice.add(parsedlistDouble3);
         }
            parsedlistDouble3 = Double.parseDouble(listOfEbay.get(i));

    }
            }catch (NoSuchElementException e){

            }
            //The following code is not implemented, but rather, it was an attempt to isolate the names from the prices in the list Arrays
            finalListtitle.add(listOfAbe.getFirst());
            for(i = 1; scnr.hasNextLine(); i++){
                int j=0;

                if(scnr.nextLine().equals(finalListprice.get(j).toString())) {

                    finalListtitle.add(listOfAbe.get(i));

                }

                }



            filterList.setWrapText(true);
            filterList2.setWrapText(true);
            filterList.setText(String.valueOf(finalListprice));
            filterList2.setText(String.valueOf(("check the catalog for book names that match the prices (order of prices: Abe, Thrift, Ebay)")));



        }

    //NOTE: the following code block follows the same annotations as detect10()
    @FXML
    public void detectFifteen(ActionEvent e) throws IOException {
        List<Double> finalListprice = new ArrayList<Double>();
        List<String> finalListtitle = new ArrayList<String>();
        List<String> listOfAbe = new ArrayList<String>();
        List<String> listOfThrift = new ArrayList<String>();
        List<String> listOfEbay = new ArrayList<String>();
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));
        Scanner scnr2 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));
        Scanner scnr3 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));
        String catalogContent;
        String catalogContent2;

        int i;
        try{
            while(scnr.hasNextLine()) {
                catalogContent = scnr.nextLine();
                listOfAbe.add(catalogContent);
            }

            for (i = 1; i <= listOfAbe.size(); i += 2) {
                double parsedlistDouble = Double.parseDouble(listOfAbe.get(i));
                if((parsedlistDouble <= 15.00) && (parsedlistDouble > 10.00)){
                    finalListprice.add(parsedlistDouble);
                }
                parsedlistDouble = Double.parseDouble(listOfAbe.get(i));


            }


            while (scnr2.hasNextLine()) {
                catalogContent2 = scnr2.nextLine();
                listOfThrift.add(catalogContent2);
            }

            for (i = 1; i < listOfThrift.size(); i += 2) {
                double parsedlistDouble2 = Double.parseDouble(listOfThrift.get(i));
                if ((parsedlistDouble2 <= 15.00) && (parsedlistDouble2 > 10.00)) {
                    finalListprice.add(parsedlistDouble2);
                }
                parsedlistDouble2 = Double.parseDouble(listOfThrift.get(i));

            }

            while (scnr3.hasNextLine()) {
                String catalogContent3 = scnr3.nextLine();
                listOfEbay.add(catalogContent3);
            }

            for (i = 1; i < listOfThrift.size(); i += 2) {
                double parsedlistDouble3 = Double.parseDouble(listOfEbay.get(i));
                if ((parsedlistDouble3 <= 15.00) && (parsedlistDouble3 > 10.00)) {
                    finalListprice.add(parsedlistDouble3);
                }
                parsedlistDouble3 = Double.parseDouble(listOfEbay.get(i));

            }
        }catch (NoSuchElementException b){

        }
        filterList.setWrapText(true);
        filterList2.setWrapText(true);
        filterList.setText(String.valueOf(finalListprice));
        filterList2.setText(String.valueOf("check the catalog for book names that match the prices (order of prices: Abe, Thrift, Ebay)"));
    }

    @FXML
    protected void filterEurope(ActionEvent event) throws IOException { //The methods looks for the word after filter in the various book titles
        //scanners read the files
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));
        Scanner europe = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\europe.txt"));
        String europeCountry;

        //Initializing the Array lists to put the book titles in
        List<String> listofbooksThrift = new ArrayList<String>();
        List<String> listofbooksEurope = new ArrayList<String>();
        String catalogtitles;
        int i = 0; //Initializng i
        while (scnr.hasNextLine()) { //loops the reading of the next line
            catalogtitles = scnr.nextLine(); //put the next line content into a variable
            listofbooksThrift.add(catalogtitles); //adds that value of that variable to the Array List

            i++;

        }
        for (i = 0; i < listofbooksThrift.size(); i++) { //iterates i in a loop
            if (listofbooksThrift.get(i).contains("Europe") || listofbooksThrift.get(i).contains("europe") ){
                listofbooksEurope.add(listofbooksThrift.get(i)); //adds the book title to a new Array List if it contains the desired words
            }
        }
        Scanner scnr2 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));

        //follows the same annotations from the thrift books process
        List<String> listofbooksAbe = new ArrayList<String>();

        String catalogtitles2;
        int j = 0;
        while (scnr2.hasNextLine()) {
            catalogtitles2 = scnr2.nextLine();
            listofbooksAbe.add(catalogtitles2);

            j++;

        }
        for (j = 0; j < listofbooksAbe.size(); j++) {
            if (listofbooksAbe.get(j).contains("Europe") || listofbooksAbe.get(j).contains("europe") ){
                listofbooksEurope.add(listofbooksAbe.get(j));
            }
        }
        //follows the same annotations from the thrift books process
        Scanner scnr3 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));


        List<String> listofbooksEbay = new ArrayList<String>();

        String catalogtitles3;
        int k = 0;
        while (scnr3.hasNextLine()) {
            catalogtitles3 = scnr3.nextLine();
            listofbooksEbay.add(catalogtitles3);

            k++;

        }
        for (k = 0; k < listofbooksEbay.size(); k++) {
            if (listofbooksEbay.get(k).contains("Europe") || listofbooksEbay.get(k).contains("europe") ){
                listofbooksEurope.add(listofbooksEbay.get(k));
            }
        }



        filterList.setWrapText(true); //removes Horizontal scrolling in the text Area
        filterList.setText(String.valueOf(listofbooksEurope)); //prints all the titles containing the desired words to the Text Area




    }


    //the following code follows the same annotations as filterEurope()
    @FXML
    protected void filterWorld(ActionEvent event) throws FileNotFoundException {
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));


        List<String> listofbooksThrift = new ArrayList<String>();
        List<String> listofbooksWorld = new ArrayList<String>();
        String catalogtitles;
        int i = 0;
        while (scnr.hasNextLine()) {
            catalogtitles = scnr.nextLine();
            listofbooksThrift.add(catalogtitles);

            i++;

        }
        for (i = 0; i < listofbooksThrift.size(); i++) {
            if ((listofbooksThrift.get(i).contains("World") || listofbooksThrift.get(i).contains("world"))){
                listofbooksWorld.add(listofbooksThrift.get(i));
            }
        }
        Scanner scnr2 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));


        List<String> listofbooksAbe = new ArrayList<String>();

        String catalogtitles2;
        int j = 0;
        while (scnr2.hasNextLine()) {
            catalogtitles2 = scnr2.nextLine();
            listofbooksAbe.add(catalogtitles2);

            j++;

        }
        for (j = 0; j < listofbooksAbe.size(); j++) {
            if ((listofbooksAbe.get(j).contains("World") || listofbooksAbe.get(j).contains("world"))){
                listofbooksWorld.add(listofbooksAbe.get(j));
            }
        }
        Scanner scnr3 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));


        List<String> listofbooksEbay = new ArrayList<String>();

        String catalogtitles3;
        int k = 0;
        while (scnr3.hasNextLine()) {
            catalogtitles3 = scnr3.nextLine();
            listofbooksEbay.add(catalogtitles3);

            k++;

        }
        for (k = 0; k < listofbooksEbay.size(); k++) {
            if ((listofbooksEbay.get(k).contains("World") || listofbooksEbay.get(k).contains("world"))){
                listofbooksWorld.add(listofbooksEbay.get(k));
            }
        }


            System.out.println(listofbooksWorld);
            filterList.setWrapText(true);
            filterList.setText(String.valueOf(listofbooksWorld));


    }
    //the following code follows the same annotations as filterEurope()
    @FXML
    protected void filterAsia(ActionEvent event) throws IOException {
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));


        List<String> listofbooksThrift = new ArrayList<String>();
        List<String> listofbooksWorld = new ArrayList<String>();
        String catalogtitles;
        int i = 0;
        while (scnr.hasNextLine()) {
            catalogtitles = scnr.nextLine();
            listofbooksThrift.add(catalogtitles);

            i++;

        }
        for (i = 0; i < listofbooksThrift.size(); i++) {
            if ((listofbooksThrift.get(i).contains("Asia") || listofbooksThrift.get(i).contains("asia"))) {
                listofbooksWorld.add(listofbooksThrift.get(i));
            }
        }
        Scanner scnr2 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));


        List<String> listofbooksAbe = new ArrayList<String>();

        String catalogtitles2;
        int j = 0;
        while (scnr2.hasNextLine()) {
            catalogtitles2 = scnr2.nextLine();
            listofbooksAbe.add(catalogtitles2);

            j++;

        }
        for (j = 0; j < listofbooksAbe.size(); j++) {
            if ((listofbooksAbe.get(j).contains("Asia") || listofbooksAbe.get(j).contains("asia"))) {
                listofbooksWorld.add(listofbooksAbe.get(j));
            }
        }
        Scanner scnr3 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));


        List<String> listofbooksEbay = new ArrayList<String>();

        String catalogtitles3;
        int k = 0;
        while (scnr3.hasNextLine()) {
            catalogtitles3 = scnr3.nextLine();
            listofbooksEbay.add(catalogtitles3);

            k++;

        }
        for (k = 0; k < listofbooksEbay.size(); k++) {
            if ((listofbooksEbay.get(k).contains("Asia") || listofbooksEbay.get(k).contains("asia"))) {
                listofbooksWorld.add(listofbooksEbay.get(k));
            }


            System.out.println(listofbooksWorld);
            filterList.setWrapText(true);
            filterList.setText(String.valueOf(listofbooksWorld));


        }
    }
    //the following code follows the same annotations as filterEurope()
    @FXML
    protected void filterAmerica(ActionEvent event) throws IOException{
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));


        List<String> listofbooksThrift = new ArrayList<String>();
        List<String> listofbooksWorld = new ArrayList<String>();
        String catalogtitles;
        int i = 0;
        while (scnr.hasNextLine()) {
            catalogtitles = scnr.nextLine();
            listofbooksThrift.add(catalogtitles);

            i++;

        }
        for (i = 0; i < listofbooksThrift.size(); i++) {
            if ((listofbooksThrift.get(i).contains("America") || listofbooksThrift.get(i).contains("america"))){
                listofbooksWorld.add(listofbooksThrift.get(i));
            }
        }
        Scanner scnr2 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));


        List<String> listofbooksAbe = new ArrayList<String>();

        String catalogtitles2;
        int j = 0;
        while (scnr2.hasNextLine()) {
            catalogtitles2 = scnr2.nextLine();
            listofbooksAbe.add(catalogtitles2);

            j++;

        }
        for (j = 0; j < listofbooksAbe.size(); j++) {
            if ((listofbooksAbe.get(j).contains("America") || listofbooksAbe.get(j).contains("america"))){
                listofbooksWorld.add(listofbooksAbe.get(j));
            }
        }
        Scanner scnr3 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));


        List<String> listofbooksEbay = new ArrayList<String>();

        String catalogtitles3;
        int k = 0;
        while (scnr3.hasNextLine()) {
            catalogtitles3 = scnr3.nextLine();
            listofbooksEbay.add(catalogtitles3);

            k++;

        }
        for (k = 0; k < listofbooksEbay.size(); k++) {
            if ((listofbooksEbay.get(k).contains("America") || listofbooksEbay.get(k).contains("america"))){
                listofbooksWorld.add(listofbooksEbay.get(k));
            }
        }


        System.out.println(listofbooksWorld);
        filterList.setWrapText(true);
        filterList.setText(String.valueOf(listofbooksWorld));



    }
    //the following code follows the same annotations as filterEurope()
    @FXML
    protected void filterWar(ActionEvent event) throws IOException{
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));


        List<String> listofbooksThrift = new ArrayList<String>();
        List<String> listofbooksWorld = new ArrayList<String>();
        String catalogtitles;
        int i = 0;
        while (scnr.hasNextLine()) {
            catalogtitles = scnr.nextLine();
            listofbooksThrift.add(catalogtitles);

            i++;

        }
        for (i = 0; i < listofbooksThrift.size(); i++) {
            if ((listofbooksThrift.get(i).contains("War") || listofbooksThrift.get(i).contains("war"))){
                listofbooksWorld.add(listofbooksThrift.get(i));
            }
        }
        Scanner scnr2 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));


        List<String> listofbooksAbe = new ArrayList<String>();

        String catalogtitles2;
        int j = 0;
        while (scnr2.hasNextLine()) {
            catalogtitles2 = scnr2.nextLine();
            listofbooksAbe.add(catalogtitles2);

            j++;

        }
        for (j = 0; j < listofbooksAbe.size(); j++) {
            if ((listofbooksAbe.get(j).contains("War") || listofbooksAbe.get(j).contains("war"))){
                listofbooksWorld.add(listofbooksAbe.get(j));
            }
        }
        Scanner scnr3 = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));


        List<String> listofbooksEbay = new ArrayList<String>();

        String catalogtitles3;
        int k = 0;
        while (scnr3.hasNextLine()) {
            catalogtitles3 = scnr3.nextLine();
            listofbooksEbay.add(catalogtitles3);

            k++;

        }
        for (k = 0; k < listofbooksEbay.size(); k++) {
            if ((listofbooksEbay.get(k).contains("War") || listofbooksEbay.get(k).contains("war"))){
                listofbooksWorld.add(listofbooksEbay.get(k));
            }
        }


        System.out.println(listofbooksWorld);
        filterList.setWrapText(true);
        filterList.setText(String.valueOf(listofbooksWorld));



    }

    @FXML
    protected void toHome(ActionEvent event) throws IOException{ //brings the user back to the home page
        Parent homeview = FXMLLoader.load(getClass().getResource("home.fxml")); //puts the file into a variable
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //prepares the stage window
        stage.setScene(new Scene(homeview)); //changes the scene to the home FXML file
        stage.show(); //displays the page window
    }

    @FXML
    protected void gotoCatalog(ActionEvent event) throws IOException { //takes the user to the catalog page
        Parent catalogview = FXMLLoader.load(getClass().getResource("catalogpage.fxml")); //puts the file into a variable
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //prepares the stage window
        stage.setScene(new Scene(catalogview)); //change the scene to the catalogPage FXML file
        stage.show(); //displays the page window
    }
    @FXML
    protected void gotofilterSearch(ActionEvent event) throws IOException {// takes the user to the filtered search page
        Parent filterview = FXMLLoader.load(getClass().getResource("filterScene.fxml")); //puts the file into a variable
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //prepares the stage window
        stage.setScene(new Scene(filterview));//change the scene to the filterScene FXML file
        stage.show();} //displays the page window




    }
