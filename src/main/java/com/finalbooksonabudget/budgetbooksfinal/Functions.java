package com.finalbooksonabudget.budgetbooksfinal;
//list of imported libraries
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
    
    public static void main(String[] args) throws FileNotFoundException { //the main class executes all the methods
        //scrapeEbay();
        //scrapeThrift();   These greyed out methods were already called, they created the txt files.
        //scrapeAbe();
        //changeToArray();
    }
    public static void scrapeEbay() throws  NumberFormatException{ //method to web scrape ebay
        String website = "https://www.ebay.com/sch/i.html?_nkw=interlink+a+traveler%27s+history&_sacat=0&_from=R40&_ipg=120";
        try{
            Scanner scnr = new Scanner(System.in);  //This method scans from System input
            Document document = Jsoup.connect(website).get(); //This turns the HTML into a readable document for JSOUP
            Elements catalogItems = document.select("div.s-item__info"); //tells jsoup to look for this HTML id
            for (Element books: catalogItems){
                String name = books.select("div.s-item__title").text(); //tells jsoup to look for the text within this HTML id
                String cost = books.select("span.s-item__price").text(); //tells jsoup to look for the text within this HTML id
                String costtwo = cost.substring(1, cost.length()-1); //excludes the dollar sign from the start of the cost

                double costfinal = Double.parseDouble(costtwo); //turns the cost into a double
                PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\ebaylistt.txt", true));

                out.write(name +"\n"); //writes the book titles to the ebay txt file
                out.write(costfinal +"\n"); //writes the book prices to the ebay txt file
                out.close(); //closes the file and print writer

            }

        }
        catch(IOException e){ //looks for exceptions
            e.printStackTrace();
        }

    }

    public static void scrapeThrift(){ //method to web scrape thrift books
        String website = "https://www.thriftbooks.com/browse/?b.search=world%20history%20books#b.s=mostPopular-desc&b.p=1&b.pp=50&b.oos&b.p.mx=15&b.tile"; //website source for the web scraper
        try{
            Scanner scnr = new Scanner(System.in); //Scans the system for input
            Document document = Jsoup.connect(website).get(); //This turns the HTML into a readable document for JSOUP
            Elements catalogItems = document.select("div.AllEditionsItem-tile"); //searches the HTML elements for this specific div
            Elements catalogItemstwo = document.select("div.SearchResultListItem-dollarAmount");
            for (Element books: catalogItems){ //for loop to cycle through every element that fits the description
                String name = books.select("a").text(); //puts the text from the "a" element into a variable called name
                String cost = books.select("div.SearchResultListItem-dollarAmount").text(); //puts the text from the "div" element into a variable called cost


                double costfinal = Double.parseDouble(cost); //turns cost into a double
                System.out.println(name);  //checks the output of name
                System.out.println(cost); //checks the output of cost
                PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\Thriftlist.txt", true)); //file to be written to

                out.write(name +"\n"); //writes all the book names to the thrift books file
                out.write(cost +"\n"); //writes all the book prices to the thrift books file
                out.close(); //closes the file and print writer

            }

        }
        catch(IOException e){
            e.printStackTrace(); //checks for exceptions
        }

    }
    public static void scrapeAbe(){ //method to web scrape Abe books
        String website = "https://www.abebooks.com/servlet/SearchResults?ds=20&kn=world+hsitory&sts=t&prh=15&prc=USD"; //sources the Html from Abe books
        try{
            Scanner scnr = new Scanner(System.in); //scans for system input
            Document document = Jsoup.connect(website).get(); //enable jsoup to read the Html from the website
            Elements catalogItems = document.select("div.cf"); //filters the searches to the div.cf element
            for (Element books: catalogItems){ //for loop to iterate through the process
                String name = books.select("h2.title").text(); //inputs the text found at the HTML element into the variable name
                String cost = books.select("p.item-price").text(); //inputs the text found at the HTML element into the variable cost



                System.out.println(name); //checks the output of name
                System.out.println(cost); //checks the output of cost
                PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\dbhol\\Downloads\\FinalProjectBooksOnaBudget\\src\\main\\resources\\com\\finalbooksonabudget\\budgetbooksfinal\\abebooks.txt", true)); //prepares to write to the abe books txt file

                out.write(name +"\n"); //writes the variable name to the abe books txt file
                out.write(cost +"\n"); //writes the variable cost to the abe books txt file
                out.close(); //closes the print and file writer

            }

        }
        catch(IOException e){
            e.printStackTrace(); //checks for exceptions
        }

    }
    public static void changeToArray() throws FileNotFoundException{ //the following code was not ultimately implemented, but I left it here to show my thought process
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

    

        
    
    

    