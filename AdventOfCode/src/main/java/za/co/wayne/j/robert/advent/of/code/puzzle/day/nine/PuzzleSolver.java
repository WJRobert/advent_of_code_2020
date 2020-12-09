package za.co.wayne.j.robert.advent.of.code.puzzle.day.nine;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.*;

public class PuzzleSolver {
    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public long solvePuzzleOne(String inputFilePath, int preambleIndex) {
        List<Long> inputNumbers = fileReader.readLongInput(inputFilePath);
        for (int i=preambleIndex; i<inputNumbers.size(); i++) {
            boolean matchFound = false;
            long supposedSum = inputNumbers.get(i);
            for (int j=i-1; j>= i-preambleIndex+1; j--) {
                for (int k=j-1; k>= i-preambleIndex; k--) {
                    if (inputNumbers.get(j) + inputNumbers.get(k) == supposedSum) {
                        matchFound = true;
                        break;
                    }
                }
                if (matchFound) {
                    break;
                }
            }
            if (!matchFound) {
                return supposedSum;
            }
        }
        return 0;
    }

    public long solvePuzzleTwo( String inputFilePath, long weaknessNumber) {
        List<Long> inputNumbers = fileReader.readLongInput(inputFilePath);
        List<Long> invalidNumberProduceRange = new ArrayList<>();
        for (int i=0; i<inputNumbers.size()-1; i++) {
            long sum = inputNumbers.get(i);
            invalidNumberProduceRange.add(sum);
            for (int j=i+1; j<inputNumbers.size(); j++) {
                long nextValue = inputNumbers.get(j);
                sum += nextValue;
                invalidNumberProduceRange.add(nextValue);
                if (sum == weaknessNumber) {
                    return addMinMax(invalidNumberProduceRange);
                } else if (sum > weaknessNumber) {
                    invalidNumberProduceRange = new ArrayList<>();
                    break;
                }
            }
        }
        return 0;
    }

    private long addMinMax(List<Long> numbersToAdd) {
        Collections.sort(numbersToAdd);
        long min = numbersToAdd.get(0);
        long max = numbersToAdd.get(numbersToAdd.size()-1);
        return min + max;
    }
}
