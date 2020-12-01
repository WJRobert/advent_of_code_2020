package za.co.wayne.j.robert.advent.of.code.puzzle;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class DayOnePuzzleSolver {

    private static final int SUM_CHECK_VALUE = 2020;
    private FileReader fileReader;

    public DayOnePuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<Integer> inputList = fileReader.readIntInput(inputFilePath);
        int size = inputList.size();
        for (int i=0; i<size-1; i++) {
            int inputOne = inputList.get(i);
            for (int j=1; j<size; j++) {
                int inputTwo = inputList.get(j);
                if (inputOne + inputTwo == SUM_CHECK_VALUE) {
                    return inputOne*inputTwo;
                }
            }
        }
        return -1;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<Integer> inputList = fileReader.readIntInput(inputFilePath);
        int size = inputList.size();
        for (int i=0; i<size-2; i++) {
            int inputOne = inputList.get(i);
            for (int j=i+1; j<size-1; j++) {
                int inputTwo = inputList.get(j);
                for (int k=j+1; k<size; k++) {
                    int inputThree = inputList.get(k);
                    if (inputOne + inputTwo + inputThree == SUM_CHECK_VALUE) {
                        return inputOne*inputTwo*inputThree;
                    }
                }

            }
        }
        return -1;
    }
}
