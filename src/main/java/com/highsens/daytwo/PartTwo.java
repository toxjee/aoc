package com.highsens.daytwo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PartTwo {

    public static void main(String[] args) {
        BufferedReader bufferedReader;

        String lineFromFile;

        List<String> allLines = new ArrayList<>();

        int maxAmountOfSameCharacters = 0;
        String lineOneFromMax;
        String lineTwoFromMax;

        try {
            bufferedReader = new BufferedReader( new FileReader("C:\\code\\aoc\\res\\inputday2.txt"));
            while( (lineFromFile = bufferedReader.readLine()) != null){
                allLines.add(lineFromFile);
            }

            ListIterator<String> listIterator = allLines.listIterator();
            while(listIterator.hasNext()){
                String currentLine = listIterator.next();
                ListIterator<String> localIterator = allLines.listIterator();
                while (localIterator.hasNext()){
                    String localLine = localIterator.next();
                    if(localLine.equals(currentLine)){
                        //fuck this shit its me.
                    } else {
                        int amountOfCorrectCharacters = findAmountOfCorrectCharacters(currentLine, localLine);

                        if (amountOfCorrectCharacters > maxAmountOfSameCharacters) {
                            maxAmountOfSameCharacters = amountOfCorrectCharacters;
                            System.out.println("new max amount of  same characters:  " + amountOfCorrectCharacters);
                            lineOneFromMax = currentLine;
                            lineTwoFromMax = localLine;
                            System.out.println("line1:" + currentLine);
                            System.out.println("line2:" + localLine);

                            //awnser = the 1 char diff in line one and two. I used kdiff its faster then programming this step.
                        }
                    }
                }

            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }

    private static int findAmountOfCorrectCharacters(String currentLine, String localLine) {
        int amount = 0;

        for (int i = 0; i < currentLine.length(); i++) {
            String characterFromCurrentLine = currentLine.substring(i, i + 1);
            String characterFromLocalLine = localLine.substring(i, i + 1);

            if (characterFromCurrentLine.equals(characterFromLocalLine)) {
                amount++;
            }
        }

        return amount;
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
