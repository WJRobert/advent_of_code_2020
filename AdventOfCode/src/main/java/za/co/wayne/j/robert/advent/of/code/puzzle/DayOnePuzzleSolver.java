package za.co.wayne.j.robert.advent.of.code.puzzle;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class DayOnePuzzleSolver {

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
                if (inputOne + inputTwo == 2020) {
                    return inputOne*inputTwo;
                }
            }
        }
        return -1;
    }
}
