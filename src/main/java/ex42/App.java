package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // method listSize returns size of ArrayList given
    public static int listSize(ArrayList<String> list){
        // object size is equal to the size of the given ArrayList
        int size = list.size();

        //return size object
        return size;
    }

    // method printData prints out all the arraylists in correct format
    public static void printData(ArrayList<String> lNames, ArrayList<String> fNames, ArrayList<String> salaries){
        // call listSize function
        int size = listSize(lNames);

        // formatted print statements
        System.out.printf("%-10s %-10s %s\n", "Last", "First", "Salary");
        System.out.println("----------------------------");

        // print out formatted input
        for(int i = 0; i < size; i++){
            System.out.printf("%-10s %-10s %s\n", lNames.get(i), fNames.get(i), salaries.get(i));
        }
    }

    // main method
    public static void main( String[] args ) throws FileNotFoundException {
        // create file name object
        File file = new File("src/main/java/ex42/exercise42_input.txt");

        // create ArrayList objects for last names, first names, and salaries
        ArrayList<String> lNames = new ArrayList<>();
        ArrayList<String> fNames = new ArrayList<>();
        ArrayList<String> salaries = new ArrayList<>();

        // read in info from file
        Scanner se = new Scanner(file);

        // stop reading after encountering a comma or new line
        se.useDelimiter(",|\\n");

        // read in info from input file, store in temp object, add temp object to appropriate ArrayList
        while(se.hasNext()){
            String temp = "";

            // read in last name and add to lName ArrayList
            temp = se.next();
            lNames.add(temp);

            // read in first name and add to fName ArrayList
            temp = se.next();
            fNames.add(temp);

            // read in salary and add to salaries ArrayList
            temp = se.nextLine();
            temp = temp.substring(1);
            salaries.add(temp);
        }

        printData(lNames, fNames, salaries);
    }

}
