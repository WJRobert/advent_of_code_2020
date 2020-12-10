package za.co.wayne.j.robert.advent.of.code.puzzle.day.ten;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PuzzleSolver {

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<Integer> inputs = fileReader.readIntInput(inputFilePath);
        Collections.sort(inputs);
        int threeJoltDiffCount = 1;
        int oneJoltDiffCount = 1;
        for (int i=0; i<inputs.size()-1; i++) {
            int diff =  inputs.get(i+1) - inputs.get(i);
            if (diff == 1) {
                oneJoltDiffCount++;
            } else if (diff == 3) {
                threeJoltDiffCount++;
            }
        }
        return  oneJoltDiffCount*threeJoltDiffCount;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        return 0;
    }
}
