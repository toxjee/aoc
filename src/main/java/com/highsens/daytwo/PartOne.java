package com.highsens.daytwo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PartOne {
    public static void main(String[] args) {
        BufferedReader bufferedReader;

        String lineFromFile;

        int amountOfTwo = 0;
        int amountOfThree = 0;

        try {
            bufferedReader = new BufferedReader( new FileReader("C:\\code\\aoc\\res\\inputday2.txt"));
            while( (lineFromFile = bufferedReader.readLine()) != null){
                if( containsTwoTheSameCharacters(lineFromFile)){
                    amountOfTwo++;
                }
                if ( containsThreeTheSameCharacters(lineFromFile)){
                    amountOfThree++;
                }

            }
            bufferedReader.close();

            System.out.println("checksum = "+ amountOfTwo + " * " + amountOfThree + " = "+ amountOfTwo*amountOfThree);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }

    private static boolean containsTwoTheSameCharacters(String lineFromFile) {
        Map<String, Integer> characterAmount = new HashMap<>();

        for (int i = 0; i < lineFromFile.length(); i++) {
            String characterFromLine = lineFromFile.substring(i, i+1);
            if(characterAmount.containsKey(characterFromLine)){
               int newAmount = characterAmount.get(characterFromLine)+1;


                characterAmount.put(characterFromLine,newAmount);

            } else {
                characterAmount.put(characterFromLine, 1);
            }
        }
        return characterAmount.values().contains(2);
    }

    private static boolean containsThreeTheSameCharacters(String lineFromFile) {
        Map<String, Integer> characterAmount = new HashMap<>();
        for (int i = 0; i < lineFromFile.length(); i++) {
            String characterFromLine = lineFromFile.substring(i, i+1);
            if(characterAmount.containsKey(characterFromLine)){
                characterAmount.put(characterFromLine,characterAmount.get(characterFromLine)+1);
            } else{
                characterAmount.put(characterFromLine, 1);
            }
        }
         return characterAmount.values().contains(3);
    }

}
