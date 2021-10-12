package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

import java.io.*;
import java.util.Scanner;

public class App {
    // makeFile method creates a file with the given path String and returns it
    public static File makeDirectory (String path){
        // create new file object from path String
        File file = new File(path);

        // create the file
        boolean bool = file.mkdirs();

        // if file couldn't be made, display error message
        if(!bool){
            System.out.println("Something went wrong, file could not be created.");
        }

        // return the file
        return file;
    }

    // printIfSuccessful method outputs a print statement if the file/directory was successfully created
    public static void printIfSuccessful (File file, String path){
        if(file.isFile() || file.isDirectory()){
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
        File websiteFile = makeDirectory(path1); // create file with makeFile method call

        // get name of author from user
        System.out.print("Author: ");
        String author = se.nextLine();

        // create the html file for the website
        String path2 = path1 + "/index.html";
        File htmlFile = new File(path2);
        htmlFile.createNewFile();

        // write to html file
        BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
        bw.write("<html><title>" + name + "</title>"); // write title
        bw.write("<meta>" + author + "</meta></html>"); // write author's name in meta tag
        bw.close(); // close writer

        // ask for JavaScript folder
        System.out.print("Do you want a folder for JavaScript? ");
        String js = se.nextLine();

        // create javascript folder variables for path and file and initialize
        String path3 = path1 + "/js/";
        File jsFile = null;

        // if yes, create folder
        if(js.matches("y")){
            jsFile = makeDirectory(path3); // make the folder
        }

        // ask for CSS folder
        System.out.print("Do you want a folder for CSS? ");
        String css = se.nextLine();

        // create css folder variables for path and file and initialize
        String path4 = path1 + "/css/"; // create css folder path
        File cssFile = null;

        // if yes, create folder
        if(css.matches("y")){
            cssFile = makeDirectory(path4); // make the folder
        }

        // if file is successfully created, print a statement to let the user know
        printIfSuccessful(websiteFile, path1);
        printIfSuccessful(htmlFile, path2);

        // print success message if they asked for js folder
        if(js.matches("y")){
            printIfSuccessful(jsFile, path3);
        }

        // print success message if they asked for css folder
        if(css.matches("y")){
            printIfSuccessful(cssFile, path4);
        }
    }
}
