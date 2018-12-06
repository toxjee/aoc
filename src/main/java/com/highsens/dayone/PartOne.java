package com.highsens.dayone;

import java.io.*;

public class PartOne {

    public static void main(String[] args) {
        BufferedReader bufferedReader;
        Integer frequency = 0;
        String lineFromFile;
        String negative = "-";
        try {
            bufferedReader = new BufferedReader( new FileReader("C:\\code\\aoc\\res\\inputday1.txt"));
            while( (lineFromFile = bufferedReader.readLine()) != null){
                Integer lineValue =  Integer.valueOf(lineFromFile.substring(1));
                if (lineFromFile.contains(negative)){
                    frequency = frequency - lineValue;
                } else {
                    frequency = frequency + lineValue;
                }

            }
            System.out.println("Result = "+ frequency);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }
}
