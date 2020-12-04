package za.co.wayne.j.robert.advent.of.code.puzzle.day.three;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class PuzzleSolver {

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        return extracted(inputs, 3, 1);
    }

    private int extracted(List<String> inputs, int rightSlope, int downSlope) {
        int indexToCheck = rightSlope;
        int length = inputs.size();
        int lineLength = inputs.get(0).length();
        int treesEncountered = 0;
        for (int i=downSlope; i<length; i+=downSlope) {
            String mapInput = inputs.get(i);
            if (mapInput.charAt(indexToCheck) == '#') {
                treesEncountered++;
            }
            indexToCheck += rightSlope;
            if (indexToCheck >= lineLength) {
                int diff = indexToCheck - lineLength;
                indexToCheck = diff;
            }
        }
        return treesEncountered;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int totalTreesEncounteredOne = extracted(inputs, 1, 1);
        int totalTreesEncounteredTwo = extracted(inputs, 3, 1);
        int totalTreesEncounteredThree = extracted(inputs, 5, 1);
        int totalTreesEncounteredFour = extracted(inputs, 7, 1);
        int totalTreesEncounteredFive = extracted(inputs, 1, 2);
        return totalTreesEncounteredOne*totalTreesEncounteredTwo*totalTreesEncounteredThree*totalTreesEncounteredFour*totalTreesEncounteredFive;
    }
}
