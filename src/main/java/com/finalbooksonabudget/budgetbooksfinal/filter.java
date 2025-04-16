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

public class filter {

    public static void main (String [] args) throws IOException {
        changetoArrayEbaytitles();
        changeToArrayEbayPrices();
        changetoArrayThriftTitles();
        changeToArrayThriftPrices();
        changetoArrayAbeTitles();
        changeToArrayAbePrices();
    }

    public static void changeToArrayEbayPrices() throws FileNotFoundException {
        List<Double> listOfPricesEbay = new ArrayList<Double>();
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt"));
        double catalogContent;

        int i = 0;
        String[] placeholder = {"a", "b", "c", "d"};
        while (scnr.hasNextLine()) {
            if (scnr.nextLine().contains("a") || scnr.nextLine().contains("i") || scnr.nextLine().contains("o") || scnr.nextLine().contains("u") || scnr.nextLine().contains("e")) {
                catalogContent = Double.parseDouble(scnr.nextLine());
                listOfPricesEbay.add(catalogContent);
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






