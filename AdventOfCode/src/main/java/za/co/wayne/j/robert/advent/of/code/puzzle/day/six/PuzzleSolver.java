package za.co.wayne.j.robert.advent.of.code.puzzle.day.six;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PuzzleSolver {

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        Set<Character> yesAnswerSet = new HashSet<>();
        int sumOfGroups = 0;
        for (String input : inputs) {
            if (input.isBlank()) {
                sumOfGroups += yesAnswerSet.size();
                yesAnswerSet = new HashSet<>();
            } else {
                for (char yesAnswer : input.toCharArray()) {
                    yesAnswerSet.add(yesAnswer);
                }
            }
        }
        sumOfGroups += yesAnswerSet.size();
        return sumOfGroups;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        Set<Character> yesAnswerSet = new HashSet<>();
        int sumOfGroups = 0;
        boolean isFirstPerson = true;
        for (String input : inputs) {
            if (input.isBlank()) {
                sumOfGroups += yesAnswerSet.size();
                yesAnswerSet = new HashSet<>();
                isFirstPerson = true;
            } else {
                if (isFirstPerson) {
                    for (char yesAnswer : input.toCharArray()) {
                        yesAnswerSet.add(yesAnswer);
                    }
                    isFirstPerson = false;
                } else {
                    Set<Character> keysToRemove = new HashSet<>(yesAnswerSet);
                    for (char yesAnswer : input.toCharArray()) {
                        keysToRemove.remove(yesAnswer);
                    }
                    if (!keysToRemove.isEmpty()) {
                        for (Character key : keysToRemove) {
                            yesAnswerSet.remove(key);
                        }
                    }
                }

            }
        }
        sumOfGroups += yesAnswerSet.size();
        return sumOfGroups;
    }
}
