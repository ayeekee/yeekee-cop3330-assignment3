package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class App {
    // readInfo method reads info from json file to use in code
    public static int readInfo(String input) throws IOException, ParseException {
        // create the parser object to read in the info
        JSONParser jsonParser = new JSONParser();

        // create a json object for the values in the file
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));

        // put the info from products in the file into an array
        JSONArray jsonArray = (JSONArray) jsonObject.get("products");

        // create iterator to go through the info in jsonArray
        Iterator itr = jsonArray.iterator();

        // create a marker to return at the end of the file
        int res = 0;

        // iterate through the array while there are still elements
        while(itr.hasNext()){
            // create another object to keep track of the item
            JSONObject item = (JSONObject) itr.next();

            // store name of item in String name to compare
            String name = (String) item.get("name");

            // check if user input matches a product name; if so, print name, price, and quantity of item
            if(input.equalsIgnoreCase(name)){
                System.out.println("Name: " + name);
                System.out.println("Price: $" + String.format("%.2f", (double) item.get("price")));
                System.out.println("Quantity: " + item.get("quantity"));
                res = 1; // update res to show we found the item
            }
        }

        if(res == 0){ // if res was not updated, the item was not found
            System.out.println("Sorry, that product was not found in our inventory.");
        }

        return res; // return result
    }

    // main method
    public static void main( String[] args ) throws IOException, ParseException {
        // create scanner object to store user input
        Scanner se = new Scanner(System.in);

        // create result variable to call function later
        int result;

        // prompt user for a product name
        System.out.print("What is the product name? ");
        String input = se.nextLine(); // store their input

        // method call to readInfo and determine if the item was found
        result = readInfo(input);

        // while the item is not found, continue asking for a product name
        while(result != 1){
            System.out.print("What is the product name? ");
            input = se.nextLine();

            result = readInfo(input); // update result each time
        }
    }
}