package com.finalbooksonabudget.budgetbooksfinal;

import javafx.application.Application;
import org.jsoup.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Functions extends Application{
    
    public static void main(String[] args) throws FileNotFoundException {
        //scrapeEbay();
        //scrapeThrift();
        //scrapeAbe();
        //changeToArray();
    }
    public static void scrapeEbay() throws  NumberFormatException{
        String website = "https://www.ebay.com/sch/i.html?_nkw=interlink+a+traveler%27s+history&_sacat=0&_from=R40&_ipg=120";
        try{
            Scanner scnr = new Scanner(System.in);
            Document document = Jsoup.connect(website).get();
            Elements catalogItems = document.select("div.s-item__info");
            for (Element books: catalogItems){
                String name = books.select("div.s-item__title").text();
                String cost = books.select("span.s-item__price").text();
                String costtwo = cost.substring(1, cost.length()-1);

                double costfinal = Double.parseDouble(costtwo);
                PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt", true));

                out.write(name +"\n");
                out.write(costfinal +"\n");
                out.close();

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void scrapeThrift(){
        String website = "https://www.thriftbooks.com/browse/?b.search=world%20history%20books#b.s=mostPopular-desc&b.p=1&b.pp=50&b.oos&b.p.mx=15&b.tile";
        try{
            Scanner scnr = new Scanner(System.in);
            Document document = Jsoup.connect(website).get();
            Elements catalogItems = document.select("div.AllEditionsItem-tile");
            Elements catalogItemstwo = document.select("div.SearchResultListItem-dollarAmount");
            for (Element books: catalogItems){
                String name = books.select("a").text();
                String cost = books.select("div.SearchResultListItem-dollarAmount").text();


                double costfinal = Double.parseDouble(cost);
                System.out.println(name);
                System.out.println(cost);
                PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt", true));

                out.write(name +"\n");
                out.write(cost +"\n");
                out.close();

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    public static void scrapeAbe(){
        String website = "https://www.abebooks.com/servlet/SearchResults?ds=20&kn=world+hsitory&sts=t&prh=15&prc=USD";
        try{
            Scanner scnr = new Scanner(System.in);
            Document document = Jsoup.connect(website).get();
            Elements catalogItems = document.select("div.cf");
            for (Element books: catalogItems){
                String name = books.select("h2.title").text();
                String cost = books.select("p.item-price").text();



                System.out.println(name);
                System.out.println(cost);
                PrintWriter out = new PrintWriter(new FileWriter("abebooks.txt", true));

                out.write(name +"\n");
                out.write(cost +"\n");
                out.close();

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    public static void changeToArray() throws FileNotFoundException{
       List<String> listOfbooksandpricesEbay = new ArrayList<String>();
       Scanner scnr = new Scanner(new FileReader("ebaylistt.txt"));
       String catalogContent;
       while (scnr.hasNext()) {
           catalogContent = scnr.next();
           listOfbooksandpricesEbay.add(catalogContent);
        }
       
      
        String[] array = listOfbooksandpricesEbay.toArray(new String[0]);
            for (String eachString : array) {
                System.out.println(eachString);
    }

    List<String> listOfbooksandpricesThrift = new ArrayList<String>();
            Scanner scnr2 = new Scanner(new FileReader("Thriftlist.txt"));
            String catalogContentThrift;
       
     
        while (scnr2.hasNext()) {
            catalogContentThrift = scnr2.next();
            listOfbooksandpricesThrift.add(catalogContentThrift);
        }
       
      
        String[] arrayThrift = listOfbooksandpricesThrift.toArray(new String[0]);
            for (String eachString : arrayThrift) {
                System.out.println(eachString);

    
    }


 
     List<String> listOfbooksandpricesAbe = new ArrayList<String>();
            Scanner scnr3 = new Scanner(new FileReader("abebooks.txt"));
            String catalogContentAbe;
        
      
         while (scnr3.hasNext()) {
             catalogContentAbe = scnr3.next();
             listOfbooksandpricesAbe.add(catalogContentAbe);
         }
        
       
         String[] arrayAbe = listOfbooksandpricesAbe.toArray(new String[0]);
             for (String eachString : arrayAbe) {
                 System.out.println(eachString);
 
     
     }
        

    }
        

 }

    

        
    
    

    