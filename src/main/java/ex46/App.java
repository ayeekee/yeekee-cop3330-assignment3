package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

import java.io.*;

public class App {
    // frequencyFinder method finds how many times the given word appears in the input file
    public static int frequencyFinder(String word) throws IOException {
        // create the necessary objects to read from file
        File file = new File("src/main/java/ex46/exercise46_input.txt");
        FileReader reader = new FileReader(file);
        BufferedReader buffReader = new BufferedReader(reader);

        // create necessary variables
        String se;
        String[] buff;
        int count=0;

        // while the next line isn't null, read through the file
        while((se = buffReader.readLine()) != null) {
            buff = se.split(" "); // read each word separated by a space

            // check if the given word matches the word in the file
            for (String match : buff) {
                if (match.equals(word)) { // if it does, update count by 1
                    count++;
                }
            }
        }

        return count; // return the number of times the word appears in the file
    }

    // printStars prints the asterisk symbol need to make the histogram for the int provided
    public static void printStars(int appears){
        // print stars until needed
        for(int i = 0; i < appears; i++){
            System.out.print("*");
        }
        System.out.println();
    }

    /* printHistogram method takes in the number of times badger, mushroom, and snake appears in the file
        creates a history based off the data */
    public static void printHistogram(int badger, int mushroom, int snake){
        // see which order to print the words from most frequent to least
        if(badger > snake){ // if badger is greater than snake
            if(badger > mushroom){ // if badger is greater than mushroom
                System.out.print("badger: "); // print badger because it's the most frequent
                printStars(badger);

                if(mushroom > snake){ // mushroom is greater than snake
                    System.out.print("mushroom: "); // print mushroom
                    printStars(mushroom);

                    System.out.print("snake: "); // then snake
                    printStars(snake);
                } else { // snake is greater than mushroom
                    System.out.print("snake: ");
                    printStars(snake);

                    System.out.print("mushroom: ");
                    printStars(mushroom);
                }
            } else { // mushroom is greater than badger
                System.out.print("mushroom: ");
                printStars(mushroom);

                System.out.print("badger: ");
                printStars(badger);

                System.out.print("snake: ");
                printStars(snake);
            }
        } else { // snake is greater than badger
            if(snake > mushroom){ // if snake is greater than mushroom
                System.out.print("snake: "); // snake is the most frequent word, so print
                printStars(snake);

                if(badger > mushroom){ // if badger is greater than mushroom
                    System.out.print("badger: ");
                    printStars(badger);

                    System.out.print("mushroom: ");
                    printStars(mushroom);
                } else { // badger is less than mushroom
                    System.out.print("mushroom: ");
                    printStars(mushroom);

                    System.out.print("badger: ");
                    printStars(badger);
                }
            } else { // mushroom is greater than snake
                System.out.print("mushroom: ");
                printStars(mushroom);

                System.out.print("snake: ");
                printStars(snake);

                System.out.print("badger: ");
                printStars(badger);
            }
        }
    }

    // main method
    public static void main( String[] args ) throws IOException {

        // create variables to store the result from the frequencyFinder method call
        int badger = frequencyFinder("badger");
        int mushroom = frequencyFinder("mushroom");
        int snake = frequencyFinder("snake");

        // method call to print the histogram
        printHistogram(badger, mushroom, snake);
    }
}
