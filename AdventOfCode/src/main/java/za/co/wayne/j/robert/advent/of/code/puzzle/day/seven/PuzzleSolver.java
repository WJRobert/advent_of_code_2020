package za.co.wayne.j.robert.advent.of.code.puzzle.day.seven;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.*;

public class PuzzleSolver {

    private static final String NO_OTHER_BAGS = "no other bags";
    private static final String SHINY_GOLD = "shiny gold";

    private FileReader fileReader;
    private Map<String, LuggageBag> luggageBagMap;

    public PuzzleSolver() {
        fileReader = new FileReader();
        luggageBagMap = new HashMap<>();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        buildLuggageMap(inputs);
        Set<String> bagColoursHoldingShinyGold = new HashSet<>();
        for (LuggageBag luggageBag: luggageBagMap.values()) {
            if (lookAndFindContainedLuggage(luggageBag) > 0) {
                bagColoursHoldingShinyGold.add(luggageBag.getType());
            }
        }
        return bagColoursHoldingShinyGold.size();
    }

    private int lookAndFindContainedLuggage(LuggageBag luggageBag) {
        int foundShinyGoldCount = 0;
        if (!luggageBag.getType().equals(SHINY_GOLD)) {
            for (ContainedLuggage containedLuggage: luggageBag.getContainedLuggageList()) {
                if (SHINY_GOLD.equals(containedLuggage.getType())) {
                    foundShinyGoldCount++;
                } else {
                    //find its contained bags
                    LuggageBag luggageBagContained = luggageBagMap.get(containedLuggage.getType());
                    foundShinyGoldCount += lookAndFindContainedLuggage(luggageBagContained);
                }
            }
        }
        return foundShinyGoldCount;
    }

    private void buildLuggageMap(List<String> inputs) {
        for (String input: inputs) {
            int pos = input.indexOf(" bags");
            String type = input.substring(0, pos).trim();
            LuggageBag luggageBag = luggageBagMap.get(type);
            if (luggageBag == null) {
                luggageBag = new LuggageBag(type,new ArrayList<>());
            }
            pos = input.indexOf("contain");
            String containedBags = input.substring(pos+7).trim();
            if (!containedBags.contains(NO_OTHER_BAGS)) {
                String[] containedBagList = containedBags.split(",");
                for (String containedBagInfo: containedBagList) {
                    pos = containedBagInfo.indexOf("bag");
                    String containedBag = containedBagInfo.substring(0, pos).trim();
                    ContainedLuggage containedLuggage = new ContainedLuggage();
                    pos = containedBag.indexOf(" ");
                    containedLuggage.setCount(Integer.parseInt(containedBag.substring(0, pos)));
                    containedLuggage.setType(containedBag.substring(pos+1).trim());
                    luggageBag.getContainedLuggageList().add(containedLuggage);
                }
            }
            luggageBagMap.put(type, luggageBag);
        }
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        buildLuggageMap(inputs);
        return calculateBagsContained(luggageBagMap.get(SHINY_GOLD)) - 1;
    }

    private int calculateBagsContained(LuggageBag luggageBag) {
        int containedBags = 1;
        for (ContainedLuggage containedLuggage: luggageBag.getContainedLuggageList()) {
            containedBags += containedLuggage.getCount()* calculateBagsContained(luggageBagMap.get(containedLuggage.getType()));
        }
        return containedBags;
    }
}
