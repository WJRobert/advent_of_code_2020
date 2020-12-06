package za.co.wayne.j.robert.advent.of.code.puzzle.day.six;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.*;

public class PuzzleSolver {

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        Map<Character, Boolean> yesAnswerMap = new HashMap<>();
        int sumOfGroups = 0;
        for (String input: inputs) {
            if (input.isBlank()) {
                sumOfGroups += yesAnswerMap.size();
                yesAnswerMap = new HashMap<>();
            } else {
                for (char yesAnswer: input.toCharArray()) {
                    yesAnswerMap.put(yesAnswer, true);
                }
            }
        }
        sumOfGroups += yesAnswerMap.size();
        return sumOfGroups;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        Map<Character, Boolean> yesAnswerMap = new HashMap<>();
        int sumOfGroups = 0;
        boolean isFirstPerson = true;
        for (String input: inputs) {
            if (input.isBlank()) {
                sumOfGroups += yesAnswerMap.size();
                yesAnswerMap = new HashMap<>();
                isFirstPerson = true;
            } else {
                if (isFirstPerson) {
                    for (char yesAnswer: input.toCharArray()) {
                            yesAnswerMap.put(yesAnswer, true);
                    }
                    isFirstPerson = false;
                } else {
                    Set<Character> keysToRemove = new HashSet<>();
                    //Else if I just remove from the set given it actually removes it from the HashMap
                    for (Character key: yesAnswerMap.keySet()) {
                        keysToRemove.add(key);
                    }

                    for (char yesAnswer: input.toCharArray()) {
                        keysToRemove.remove(yesAnswer);
                    }
                    if (!keysToRemove.isEmpty()) {
                        for (Character key : keysToRemove) {
                            yesAnswerMap.remove(key);
                        }
                    }
                }

            }
        }
        sumOfGroups += yesAnswerMap.size();
        return sumOfGroups;
    }
}
