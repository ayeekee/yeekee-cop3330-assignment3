package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class App 
{
    // method takes in ArrayList and sorts elements alphabetically
    public static ArrayList<String> sortedNames (ArrayList<String> names){
        // create sorted ArrayList
        ArrayList<String> sorted = new ArrayList<>();

        // sort elements in original array
        Collections.sort(names);

        // put sorted elements into sorted array
        sorted = names;

        //return sorted ArrayList
        return sorted;
    }

    // main method
    public static void main( String[] args ) throws FileNotFoundException {
        // create file name object
        File file = new File("src/main/java/ex41/exercise41_input.txt");

        // create ArrayList object for original and sorted list
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> sorted = new ArrayList<>();

        // read in file input and add to names ArrayList
        try (Scanner se = new Scanner(new FileReader(file))) {
            while (se.hasNext()) {
                names.add(se.nextLine());
            }
        }

        // call sorting method and return sorted list to sorted ArrayList
        sorted = sortedNames(names);

        // write to output file
        try {
            // create output file
            FileWriter fileWriter = new FileWriter("src/main/java/ex41/exercise41_output.txt");

            // Print statements
            fileWriter.write("Total of " + names.size() + " names\n");
            fileWriter.write("-------------------\n");

            // Print sorted ArrayList elements
            for(int i = 0; i < names.size(); i++){
                fileWriter.write(sorted.get(i) + "\n");
            }

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
