package com.highsens.dayone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PartTwo {
    public static void main(String[] args) {
        BufferedReader bufferedReader;
        Integer frequency = 0;
        String lineFromFile;
        String negative = "-";
        String positive = "+";
        ArrayList<Integer> seenFrequencies = new ArrayList<>();
        try {
            boolean result = false;
            while(!result){
                bufferedReader = new BufferedReader( new FileReader("C:\\code\\aoc\\res\\inputday1.txt"));
                while( (lineFromFile = bufferedReader.readLine()) != null){

                    Integer lineValue =  Integer.valueOf(lineFromFile.substring(1));
                    if (lineFromFile.contains(negative)){
                        frequency = frequency - lineValue;
                    }
                    if (lineFromFile.contains(positive)){
                        frequency = frequency + lineValue;
                    }
                    if(seenFrequencies.contains(frequency)) {
                        System.out.println("Result = " + frequency);
                        result = true;
                        break;
                    }
                    seenFrequencies.add(frequency);
                }
                bufferedReader.close();
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }
}
