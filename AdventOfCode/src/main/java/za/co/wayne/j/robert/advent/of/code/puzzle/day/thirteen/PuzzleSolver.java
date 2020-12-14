package za.co.wayne.j.robert.advent.of.code.puzzle.day.thirteen;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.*;

public class PuzzleSolver {

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        Integer earliestTimeStamp = Integer.parseInt(inputs.get(0));
        List<Integer> busIDs = getBusIDs(inputs.get(1));
        int bestBusId = Integer.MAX_VALUE;
        int bestBusTime = Integer.MAX_VALUE;
        for (Integer busID: busIDs) {
            int divide = earliestTimeStamp/busID;
            divide++;
            int busCount = divide*busID;
            if (busCount < bestBusTime) {
                bestBusTime = busCount;
                bestBusId = busID;
            }
        }
        int timeToWait = bestBusTime - earliestTimeStamp;

        return timeToWait * bestBusId;
    }

    private List<Integer> getBusIDs(String busses) {
        List<Integer> busIDs = new ArrayList<>();
        String[] possibleBusIds = busses.split(",");
        for (String busId: possibleBusIds) {
            if (!busId.equals("x")) {
                busIDs.add(Integer.parseInt(busId));
            }
        }
        return busIDs;
    }

    public long solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        Map<Integer, Long> busPositions = generateBusPositions(inputs.get(1));
        Map<Integer, Long> currentBusPositions = new HashMap<>(busPositions);
        List<Integer> sortedKeys = new ArrayList<>(busPositions.keySet());
        Collections.sort(sortedKeys);
        boolean isValid = false;
        long currentTime = 99999999999972L;
        long firstBusId = busPositions.get(sortedKeys.get(0));
        while (!isValid) {
            currentTime += firstBusId;
            for (Integer key: sortedKeys) {
                long busId = busPositions.get(key);
                if (busId == firstBusId) {
                    currentBusPositions.put(key, currentTime);
                } else {
                    long multiplier = currentTime / busId;
                    currentBusPositions.put(key, (multiplier + 1) * busId);
                }
            }
            isValid = isBusPositionsValid(currentBusPositions, sortedKeys);
        }
        return currentTime;
    }

    private Map<Integer, Long> generateBusPositions(String busses) {
        Map<Integer, Long> busPositions = new HashMap<>();
        String[] possibleBusIds = busses.split(",");
        for (int i=0; i<possibleBusIds.length; i++) {
            String busID = possibleBusIds[i];
            if (!busID.equals("x")) {
                busPositions.put(i, Long.parseLong(busID));
            }
        }

        return busPositions;
    }

    private boolean isBusPositionsValid(Map<Integer, Long> currentBusPositions, List<Integer> sortedKeys) {
        for (int i=sortedKeys.size()-1; i>0; i--) {
            int indexOne = sortedKeys.get(i);
            int indexTwo = sortedKeys.get(i-1);
            int currentDiff = indexOne-indexTwo;
            if (currentBusPositions.get(indexOne) - currentBusPositions.get(indexTwo) != currentDiff) {
                return false;
            }
        }
        return true;
    }
}
