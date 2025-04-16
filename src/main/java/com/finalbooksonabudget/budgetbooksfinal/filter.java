package com.finalbooksonabudget.budgetbooksfinal;

import com.almasb.fxgl.core.collection.Array;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


//This class is a testing page for methods that were to be used in the controller class.
public class filter {

    public static void main (String [] args) throws IOException {
        changetoArrayEbaytitles();  //the following lines of code call the methods that put information from the txt files into an Array
        changeToArrayEbayPrices();
        changetoArrayThriftTitles();
        changeToArrayThriftPrices();
        changetoArrayAbeTitles();
        changeToArrayAbePrices();
    }

    public static void changeToArrayEbayPrices() throws FileNotFoundException {
        List<Double> listOfPricesEbay = new ArrayList<Double>(); //This puts the Ebay prices from the txt file into a Double array
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));
        double catalogContent;

        int i = 0;

        while (scnr.hasNextLine()) {
            if (scnr.nextLine().contains("a") || scnr.nextLine().contains("i") || scnr.nextLine().contains("o") || scnr.nextLine().contains("u") || scnr.nextLine().contains("e")) {
                catalogContent = Double.parseDouble(scnr.nextLine()); //Parsing the nexLine() method with the parse double method turns the scanned string from the next line into a double. this allows me to create a seprate double array from the string array.
                listOfPricesEbay.add(catalogContent); //this adds the parsed input into the list of prices double arrayList
                System.out.println(listOfPricesEbay.get(i));
                i++;
            } else {
                String next = scnr.nextLine();
            }
        }
    }

        public static void changetoArrayEbaytitles() throws IOException {

            Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));

            List<String> listofbooksEbay = new ArrayList <String>();
            String catalogtitles;
            int i = 0;
            while (scnr.hasNextLine()){
                    catalogtitles = scnr.nextLine();
                    listofbooksEbay.add(catalogtitles);

                    i++;

            }
            for (i = 0; i < listofbooksEbay.size(); i += 2){
                System.out.println(listofbooksEbay.get(i));
            }





    }
        public static void changetoArrayThriftTitles() throws IOException {
            Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));

            List<String> listofbooksThrift = new ArrayList <String>();
            String catalogtitles;
            int i = 0;
            while (scnr.hasNextLine()){
                catalogtitles = scnr.nextLine();
                listofbooksThrift.add(catalogtitles);

                i++;

            }
            for (i = 0; i < listofbooksThrift.size(); i += 2){
                System.out.println(listofbooksThrift.get(i));
            }
        }

    public static void changeToArrayThriftPrices() throws FileNotFoundException {
        List<Double> listOfPricesThrift = new ArrayList<Double>();
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt"));
        double catalogContent;

        int i = 0;
        String[] placeholder = {"a", "b", "c", "d"};
        while (scnr.hasNextLine()) {
            if (scnr.nextLine().contains("a") || scnr.nextLine().contains("i") || scnr.nextLine().contains("o") || scnr.nextLine().contains("u") || scnr.nextLine().contains("e")) {
                catalogContent = Double.parseDouble(scnr.nextLine());
                listOfPricesThrift.add(catalogContent);
                System.out.println(listOfPricesThrift.get(i));
                i++;
            } else {
                String next = scnr.nextLine();
            }
        }
    }
    public static void changetoArrayAbeTitles() throws IOException {
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));



        List<String> listofbooksAbe = new ArrayList <String>();
        String catalogtitles;
        int i = 0;
        while (scnr.hasNextLine()){
            catalogtitles = scnr.nextLine();
            listofbooksAbe.add(catalogtitles);

            i++;

        }
        for (i = 0; i < listofbooksAbe.size(); i += 2){
            System.out.println(listofbooksAbe.get(i));
        }
    }
    public static void changeToArrayAbePrices() throws FileNotFoundException {
        List<Double> listOfPricesAbe = new ArrayList<Double>();
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt"));
        double catalogContent;

        int i = 0;
        String[] placeholder = {"a", "b", "c", "d"};
        while (scnr.hasNextLine()) {
            if (scnr.nextLine().contains("a") || scnr.nextLine().contains("i") || scnr.nextLine().contains("o") || scnr.nextLine().contains("u") || scnr.nextLine().contains("e")) {
                catalogContent = Double.parseDouble(scnr.nextLine());
                listOfPricesAbe.add(catalogContent);
                System.out.println(listOfPricesAbe.get(i));
                i++;
            } else {
                String next = scnr.nextLine();
            }
        }
    }






            }






