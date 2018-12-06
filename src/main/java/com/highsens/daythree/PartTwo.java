package com.highsens.daythree;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PartTwo {

    public static Map<FabricPieceClaim, Integer> amountOfClaimsPerFabricPiece;
    public static Map<Integer, Integer> claimIdPerNeededFabric;
    public static Map<Integer, Integer> claimIdNotOverlappingFabric;

    public static void main(String[] args) throws IOException {
        amountOfClaimsPerFabricPiece = new HashMap<>();
        claimIdPerNeededFabric = new HashMap<>();
        claimIdNotOverlappingFabric = new HashMap<>();

        BufferedReader bufferedReader;
        String lineFromFile;

        bufferedReader = new BufferedReader(new FileReader("C:\\code\\aoc\\res\\inputday3.txt"));
        while ((lineFromFile = bufferedReader.readLine()) != null) {
            addClaimsOnFabricForLine(lineFromFile);
        }
        bufferedReader.close();

        int countOfMultipleClaim = 0;

        Set<FabricPieceClaim> fabricPieces = amountOfClaimsPerFabricPiece.keySet();
        for (FabricPieceClaim fabricPiece : fabricPieces) {
            if (amountOfClaimsPerFabricPiece.get(fabricPiece) == 1) {
                if(claimIdNotOverlappingFabric.get(fabricPiece.getClaimId()) == null){
                    claimIdNotOverlappingFabric.put(fabricPiece.getClaimId(), 1);
                } else {
                    claimIdNotOverlappingFabric.put(fabricPiece.getClaimId(), claimIdNotOverlappingFabric.get(fabricPiece.getClaimId())+1);
                    if (claimIdNotOverlappingFabric.get(fabricPiece.getClaimId()) == (claimIdPerNeededFabric.get(fabricPiece.getClaimId())-1)){
                        System.out.println("claimId: "+fabricPiece.getClaimId());
                    }
                }
            }
        }

    }

    private static void addClaimsOnFabricForLine(String lineFromFile) {
        int claimId = Integer.valueOf(StringUtils.substringBetween(lineFromFile, "#", " "));
        int startXpos = Integer.valueOf(StringUtils.substringBetween(lineFromFile, "@ ", ",")) + 1;
        int startYpos = Integer.valueOf(StringUtils.substringBetween(lineFromFile, ",", ":")) + 1;
        int widthX = Integer.valueOf(StringUtils.substringBetween(lineFromFile, ": ", "x"));
        int lengthY = Integer.valueOf(StringUtils.substringAfter(lineFromFile, "x"));

       // System.out.println("startXpos: " + startXpos + " startYpos: " + startYpos + " widthX: " + widthX + "lengthY " + lengthY + " claimId"+ claimId);
        claimIdPerNeededFabric.put(claimId, widthX*lengthY);

        for (int i = 0; i < widthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                FabricPieceClaim currentPieceToClaim = new FabricPieceClaim(startXpos + i, startYpos + j, claimId);
                if (amountOfClaimsPerFabricPiece.containsKey(currentPieceToClaim)) {
                    amountOfClaimsPerFabricPiece.put(currentPieceToClaim, amountOfClaimsPerFabricPiece.get(currentPieceToClaim) + 1);
                } else {
                    amountOfClaimsPerFabricPiece.put(currentPieceToClaim, 1);
                }

            }
        }
    }

}
