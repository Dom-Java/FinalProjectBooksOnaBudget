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
    public void showThrift() throws FileNotFoundException {
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));


        List<String> listofbooksThrift = new ArrayList<String>();
        String catalogtitles;
        int i = 0;
        while (scnr.hasNextLine()) {
            catalogtitles = scnr.nextLine();
            listofbooksThrift.add(catalogtitles);

            i++;

        }
        for (i = 0; i < listofbooksThrift.size(); i += 2) {
            System.out.println(listofbooksThrift.get(i));
            CatalogArea.setWrapText(true);
            CatalogArea.setText(String.valueOf(listofbooksThrift));
        }
    }

    @FXML
    public void showEbay() throws IOException {
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));


        List<String> listofbooksThrift = new ArrayList<String>();
        String catalogtitles;
        int i = 0;
        while (scnr.hasNextLine()) {
            catalogtitles = scnr.nextLine();
            listofbooksThrift.add(catalogtitles);

            i++;

        }
        for (i = 0; i < listofbooksThrift.size(); i += 2) {
            System.out.println(listofbooksThrift.get(i));
            CatalogArea.setWrapText(true);
            CatalogArea.setText(String.valueOf(listofbooksThrift));
        }

    }

    @FXML
    private TextArea CatalogArea;

    @FXML
    public void showAbe() throws IOException {


        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));


        List<String> listofbooksAbe = new ArrayList<String>();
        String catalogtitles;
        int i = 0;
        while (scnr.hasNextLine()) {
            catalogtitles = scnr.nextLine();
            listofbooksAbe.add(catalogtitles);

            i++;

        }
        for (i = 0; i < listofbooksAbe.size(); i += 2) {
            System.out.println(listofbooksAbe.get(i));
            CatalogArea.setWrapText(true);
            CatalogArea.setText(String.valueOf(listofbooksAbe));
        }

    }


    @FXML
    protected void detectTen() throws IOException{
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
                if((parsedlistDouble <= 10.00) && (parsedlistDouble > 5.00)){
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
                if ((parsedlistDouble2 <= 10.00) && (parsedlistDouble2 > 5.00)) {
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
                if ((parsedlistDouble3 <= 10.00) && (parsedlistDouble3 > 5.00)) {
                    finalListprice.add(parsedlistDouble3);
                }
                parsedlistDouble3 = Double.parseDouble(listOfEbay.get(i));

            }
        }catch (NoSuchElementException b){

        }
        filterList.setWrapText(true);
        filterList2.setWrapText(true);
        filterList.setText(String.valueOf(finalListprice));
        filterList2.setText(String.valueOf(("check the catalog for book names that match the prices (order of prices: Abe, Thrift Ebay)")));
    }

    @FXML
    private TextArea filterList;
    @FXML
    private TextArea filterList2;
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
            finalListtitle.add(listOfAbe.getFirst());
            for(i = 1; scnr.hasNextLine(); i++){
                int j=0;

                if(scnr.nextLine().equals(finalListprice.get(j).toString())) {

                    finalListtitle.add(listOfAbe.get(i));

                }

                }


        //for (i = 0; scnr.hasNextLine(); i++){

            //if (listOfAbe.contains(finalListprice.get(i).toString())) {
           //     finalListtitle.add(listOfAbe.get(i));
           // }

            //}



            filterList.setWrapText(true);
            filterList2.setWrapText(true);
            filterList.setText(String.valueOf(finalListprice));
            filterList2.setText(String.valueOf(("check the catalog for book names that match the prices (order of prices: Abe, Thrift Ebay)")));



        }


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
        filterList2.setText(String.valueOf("check the catalog for book names that match the prices (order of prices: Abe, Thrift Ebay)"));
    }

    @FXML
    protected void filterEurope(ActionEvent event) throws IOException {
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));
        Scanner europe = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\europe.txt"));
        String europeCountry;


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
            if (listofbooksThrift.get(i).contains("Europe") || listofbooksThrift.get(i).contains("europe") ){
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
            if (listofbooksAbe.get(j).contains("Europe") || listofbooksAbe.get(j).contains("europe") ){
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
            if (listofbooksEbay.get(k).contains("Europe") || listofbooksEbay.get(k).contains("europe") ){
                listofbooksWorld.add(listofbooksEbay.get(k));
            }
        }



        filterList.setWrapText(true);
        filterList.setText(String.valueOf(listofbooksWorld));




    }

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
    protected void toHome(ActionEvent event) throws IOException{
        Parent homeview = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(homeview));
        stage.show();
    }

    @FXML
    protected void gotoCatalog(ActionEvent event) throws IOException {
        Parent catalogview = FXMLLoader.load(getClass().getResource("catalogpage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(catalogview));
        stage.show();
    }
    @FXML
    protected void gotofilterSearch(ActionEvent event) throws IOException {
        Parent filterview = FXMLLoader.load(getClass().getResource("filterScene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(filterview));
        stage.show();}




    }
