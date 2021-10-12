package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

import java.io.*;
import java.util.HashMap;
import java.util.*;

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

    // main method
    public static void main( String[] args ) throws IOException {

        // create variables to store the result from the frequencyFinder method call
        int badger = frequencyFinder("badger");
        int mushroom = frequencyFinder("mushroom");
        int snake = frequencyFinder("snake");

        // create hashmap to put values in
        HashMap<String, Integer> map = new HashMap<>();
        map.put("badger", badger);
        map.put("mushroom", mushroom);
        map.put("snake", snake);

        // use LinkedHashMap to preserve order of sorting
        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();

        // reverse order the map so it's sorted from most frequent to least
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

        // print out histogram
        for (Map.Entry<String, Integer> entry : sorted.entrySet()){
            // store value in int variable to use for loop
            int value = entry.getValue();

            // print words from greatest to least frequent
            System.out.print(entry.getKey() +": ");

            // print stars
            for(int i = 0; i < value; i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
