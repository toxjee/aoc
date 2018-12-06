package com.highsens.daythree;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PartOne {

    public static Map<FabricPiece, Integer> amountOfClaimsPerFabricPiece;

    public static void main(String[] args) throws IOException {
        amountOfClaimsPerFabricPiece = new HashMap<>();
        BufferedReader bufferedReader;
        String lineFromFile;

        bufferedReader = new BufferedReader(new FileReader("C:\\code\\aoc\\res\\inputday3.txt"));
        while ((lineFromFile = bufferedReader.readLine()) != null) {
            addClaimsOnFabricForLine(lineFromFile);
        }
        bufferedReader.close();

        int countOfMultipleClaim = 0;

        Set<FabricPiece> fabricPieces = amountOfClaimsPerFabricPiece.keySet();
        for (FabricPiece fabricPiece : fabricPieces) {
            if (amountOfClaimsPerFabricPiece.get(fabricPiece) > 1) {
                countOfMultipleClaim++;
            }
        }

        System.out.println(countOfMultipleClaim);
    }

    private static void addClaimsOnFabricForLine(String lineFromFile) {
        int startXpos = Integer.valueOf(StringUtils.substringBetween(lineFromFile, "@ ", ",")) + 1;
        int startYpos = Integer.valueOf(StringUtils.substringBetween(lineFromFile, ",", ":")) + 1;
        int widthX = Integer.valueOf(StringUtils.substringBetween(lineFromFile, ": ", "x"));
        int lengthY = Integer.valueOf(StringUtils.substringAfter(lineFromFile, "x"));

        System.out.println("startXpos: " + startXpos + " startYpos: " + startYpos + " widthX: " + widthX + "lengthY " + lengthY);
        for (int i = 0; i < widthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                FabricPiece currentPieceToClaim = new FabricPiece(startXpos + i, startYpos + j);
                if (amountOfClaimsPerFabricPiece.containsKey(currentPieceToClaim)) {
                    System.out.println("already claimed: x:" + currentPieceToClaim.getX() + " y:" + currentPieceToClaim.getY());
                    amountOfClaimsPerFabricPiece.put(currentPieceToClaim, amountOfClaimsPerFabricPiece.get(currentPieceToClaim) + 1);
                } else {
                    amountOfClaimsPerFabricPiece.put(currentPieceToClaim, 1);
                }

            }
        }


    }


}
