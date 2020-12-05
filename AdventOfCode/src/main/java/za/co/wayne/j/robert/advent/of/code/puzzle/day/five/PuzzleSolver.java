package za.co.wayne.j.robert.advent.of.code.puzzle.day.five;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;
import java.util.Map;

public class PuzzleSolver {

    private final static int ROW_MAX = 127;
    private final static int COL_MAX = 7;

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int highestSeatId = 0;
        for (String input : inputs) {
            int rowId = findNextRemainder(input.substring(0,7), 0 , ROW_MAX, 'F');
            int colId = findNextRemainder(input.substring(7), 0 , COL_MAX, 'L');
            int seatId = (rowId*8)+colId;
            if (seatId > highestSeatId) {
                highestSeatId = seatId;
            }
        }
        return highestSeatId;
    }

    private int findNextRemainder(String remainder, int min, int max, char bottomHalf) {
        char nextRow = remainder.charAt(0);
        int remainderRowLength = remainder.length();
        int diffHalf = (max+1 - min)/2;
        if (nextRow == bottomHalf) {
            //Front half
            if (remainderRowLength == 1) {
                return min;
            } else {
                return findNextRemainder(remainder.substring(1), min, min+diffHalf-1, bottomHalf);
            }
        } else {
            //Back half
            if (remainderRowLength == 1) {
                return max;
            } else {
                return findNextRemainder(remainder.substring(1), max+1-diffHalf, max, bottomHalf);
            }
        }
    }

    public int solvePuzzleTwo(int highestSeat, String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int[] seats = new int[highestSeat];
        for (String input : inputs) {
            int rowId = findNextRemainder(input.substring(0,7), 0 , ROW_MAX, 'F');
            int colId = findNextRemainder(input.substring(7), 0 , COL_MAX, 'L');
            int seatId = (rowId*8)+colId;
            seats[seatId-1] = 1;
        }
        for (int i=1; i<highestSeat-2; i++) {
            if (seats[i] != 1 && seats[i-1] == 1 && seats[i+1] == 1) {
                return i+1;
            }
        }
        return 0;
    }
}
