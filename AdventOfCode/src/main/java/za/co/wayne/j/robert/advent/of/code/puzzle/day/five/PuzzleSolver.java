package za.co.wayne.j.robert.advent.of.code.puzzle.day.five;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class PuzzleSolver {

    private final static int ROW_MAX = 127;
    private final static int COL_MAX = 7;
    private final static int ROW_INDICATOR_LENGTH = 7;
    private final static char ROW_BOTTOM_HALF_INDICATOR = 'F';
    private final static char COL_BOTTOM_HALF_INDICATOR = 'L';

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> boardingPassList = fileReader.readInput(inputFilePath);
        int highestSeatId = 0;
        for (String boardingPass : boardingPassList) {
            int seatId = calculateSeatId(boardingPass);
            if (seatId > highestSeatId) {
                highestSeatId = seatId;
            }
        }
        return highestSeatId;
    }

    private int calculateSeatId(String boardingPass) {
        int rowId = findBoardingPassIndex(boardingPass.substring(0, ROW_INDICATOR_LENGTH), 0, ROW_MAX, ROW_BOTTOM_HALF_INDICATOR);
        int colId = findBoardingPassIndex(boardingPass.substring(ROW_INDICATOR_LENGTH), 0, COL_MAX, COL_BOTTOM_HALF_INDICATOR);
        return (rowId * 8) + colId;
    }

    private int findBoardingPassIndex(String boardingPass, int min, int max, char bottomHalf) {
        char nextBoardingPassIndex = boardingPass.charAt(0);
        int boardingPassLength = boardingPass.length();
        int diffHalf = (max + 1 - min) / 2;
        if (nextBoardingPassIndex == bottomHalf) {
            //Front half
            if (boardingPassLength == 1) {
                return min;
            } else {
                return findBoardingPassIndex(boardingPass.substring(1), min, min + diffHalf - 1, bottomHalf);
            }
        } else {
            //Back half
            if (boardingPassLength == 1) {
                return max;
            } else {
                return findBoardingPassIndex(boardingPass.substring(1), max + 1 - diffHalf, max, bottomHalf);
            }
        }
    }

    public int solvePuzzleTwo(int highestSeat, String inputFilePath) {
        List<String> boardingPassList = fileReader.readInput(inputFilePath);
        int[] seats = new int[highestSeat];
        for (String boardingPass : boardingPassList) {
            seats[calculateSeatId(boardingPass) - 1] = 1;
        }
        for (int i = 1; i < highestSeat - 2; i++) {
            if (seats[i] != 1 && seats[i - 1] == 1 && seats[i + 1] == 1) {
                return i + 1;
            }
        }
        return 0;
    }
}
