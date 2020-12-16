package za.co.wayne.j.robert.advent.of.code.puzzle.day.fourteen;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.*;

public class PuzzleSolver {

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public long solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        String bitMask = "";
        int maskLength = 0;
        Map<Integer, Long> memoryValues = new HashMap<>();
        for (String inputLine : inputs) {
            if (inputLine.startsWith("mem[")) {
                int pos = inputLine.indexOf("=");
                long decimalValue = Long.parseLong(inputLine.substring(pos + 1).trim());
                long maskedValue = maskValue(bitMask, decimalValue, maskLength);
                memoryValues.put(getMemoryLocation(inputLine), maskedValue);
            } else {
                int pos = inputLine.indexOf("=");
                bitMask = inputLine.substring(pos + 1).trim();
                maskLength = bitMask.length();
            }
        }
        long sum = 0L;
        for (Long value : memoryValues.values()) {
            sum += value;
        }
        return sum;
    }

    private long maskValue(String mask, long valueToMask, int maskLength) {
        String bitString = Long.toBinaryString(valueToMask);
        String newBitString = "";
        int bitStringLength = bitString.length();
        while (bitStringLength < maskLength) {
            bitString = "0" + bitString;
            bitStringLength = bitString.length();
        }
        for (int i = bitStringLength - 1; i >= 0; i--) {
            if (mask.charAt(i) == 'X') {
                newBitString = bitString.charAt(i) + newBitString;
            } else {
                newBitString = mask.charAt(i) + newBitString;
            }
        }
        return Long.parseLong(newBitString, 2);
    }

    private int getMemoryLocation(String memoryString) {
        int posFirstBracket = memoryString.indexOf("[");
        int posSecondBracket = memoryString.indexOf("]");
        return Integer.parseInt(memoryString.substring(posFirstBracket + 1, posSecondBracket));
    }

    public long solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        return 0;
    }
}
