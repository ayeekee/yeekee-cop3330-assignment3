package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

import java.io.*;
import java.util.Scanner;

public class App {
    // makeFile method creates a file with the given path String and returns true if successfully created
    public static boolean makeFile (String path){
        // create new file object from path String
        File file = new File(path);

        // create the file
        boolean bool = file.mkdirs();

        // return true or false
        return bool;
    }

    // printIfSuccessful method outputs a print statement if the file was successfully created
    public static void printIfSuccessful (String path, boolean bool){
        if(bool){
            System.out.println("Created " + path);
        }
    }

    // main method
    public static void main( String[] args ) throws IOException {
        // create scanner object
        Scanner se = new Scanner(System.in);

        // base path for all files to be created
        String path = "src/main/java/ex43/website/";

        // get name of site from user
        System.out.print("Site name: ");
        String name = se.nextLine();
        String path1 = path + name; // path updated to user's input
        Boolean bool1 = makeFile(path1); // create file with makeFile method call
        printIfSuccessful(path1, bool1); // if file is successfully created, print a statement to let the user know

        // get name of author from user
        System.out.print("Author: ");
        String author = se.nextLine();

        // create the html file for the website
        File htmlFile = new File(path1 + "/index.html"); // update html file path
        if (htmlFile.createNewFile()) {
            System.out.println("Created " + htmlFile);
        }

        // write to html file
        BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
        bw.write("<html><title>" + name + "</title>"); // write title
        bw.write("<meta>" + author + "</meta></html>"); // write author's name in meta tag
        bw.close(); // close writer

        // ask for JavaScript folder
        System.out.print("Do you want a folder for JavaScript? ");
        String js = se.nextLine();

        // if yes, create folder
        if(js.matches("y")){
            String path2 = path1 + "/js"; // create js folder path
            Boolean bool2 = makeFile(path2); // make the folder
            printIfSuccessful(path2, bool2); // print if successful
        }

        // ask for CSS folder
        System.out.print("Do you want a folder for CSS? ");
        String css = se.nextLine();

        // if yes, create folder
        if(css.matches("y")){
            String path3 = path1 + "/css"; // create css folder path
            Boolean bool3 = makeFile(path3); // make the folder
            printIfSuccessful(path3, bool3); // print if successful
        }
    }
}
