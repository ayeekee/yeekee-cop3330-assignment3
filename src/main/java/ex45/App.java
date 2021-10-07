package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

import java.io.*;
import java.util.Scanner;

public class App {

    /* replaceWord method takes the String of a path file, reading input from that file, and returns a
    new string with the words "utilize" replaced by "use". */
    public static String replaceWord(String path) throws IOException {
        // create file object for input file
        File file = new File(path);

        // declare old and new string variables
        String old = "";
        String newString = "";

        // create reader object to read from file
        BufferedReader reader = null;

        try {
            // read from input file
            reader = new BufferedReader(new FileReader(file));

            // set String line equal to first line
            String line = reader.readLine();

            // while line is not empty, read in input file string to old String; line moves to next line
            while (line != null) {
                old = old + line + System.lineSeparator();

                line = reader.readLine();
            }

            // replace "utilize" with "use" and store new content in newString
            newString = old.replaceAll("utilize", "use");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            reader.close(); // close reader
        }

        return newString; // return the content to be printed to output file
    }

    // main method
    public static void main( String[] args ) throws IOException {
        // create path variable
        String path = ("src/main/java/ex45/exercise45_input.txt");

        // replaceWord method call, store String in newString
        String newString = replaceWord(path);

        // find out what the user wants the output file to be called
        Scanner se = new Scanner(System.in);
        System.out.print("What is the name of the output file? ");
        String outputName = se.nextLine(); // get user input

        File outputFile = new File("src/main/java/ex45/" + outputName); // create output file

        // write to output file
        FileWriter writer = null;
        writer = new FileWriter(outputFile);
        writer.write(newString); // write content in newString to output file

        writer.close(); // closer writer
    }
}
