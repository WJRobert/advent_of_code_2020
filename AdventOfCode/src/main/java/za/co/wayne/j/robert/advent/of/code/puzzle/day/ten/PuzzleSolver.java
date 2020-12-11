package za.co.wayne.j.robert.advent.of.code.puzzle.day.ten;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.*;

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

    public long solvePuzzleTwo(String inputFilePath) {
        List<Integer> adapters = fileReader.readIntInput(inputFilePath);
        Collections.sort(adapters);
        Map<Integer, Long> combinations = new HashMap<>();
        combinations.put(0, 1L);
//        combinations.put(1, 2);
        int lastAdapter = 0;
        for (Integer adapter: adapters) {
            long currentCombination = 0;
            lastAdapter = adapter;
            if (combinations.containsKey(adapter-1)) {
                currentCombination += combinations.get(adapter-1);
            }
            if (combinations.containsKey(adapter-2)) {
                currentCombination += combinations.get(adapter-2);
            }
            if (combinations.containsKey(adapter-3)) {
                currentCombination += combinations.get(adapter-3);
            }
            combinations.put(adapter, currentCombination);
        }

        List<Long> combinationSet = new ArrayList<>(combinations.values());
        Collections.sort(combinationSet);
        return combinationSet.get(combinationSet.size()-1);
    }
}
