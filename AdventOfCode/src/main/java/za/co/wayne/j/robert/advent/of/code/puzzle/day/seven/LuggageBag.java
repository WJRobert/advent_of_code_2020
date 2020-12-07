package za.co.wayne.j.robert.advent.of.code.puzzle.day.seven;

import java.util.List;

public class LuggageBag {

    private String type;
    private List<ContainedLuggage> containedLuggageList;

    public LuggageBag() {
    }

    public LuggageBag(String type, List<ContainedLuggage> containedLuggageList) {
        this.type = type;
        this.containedLuggageList = containedLuggageList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ContainedLuggage> getContainedLuggageList() {
        return containedLuggageList;
    }

    public void setContainedLuggageList(List<ContainedLuggage> containedLuggageList) {
        this.containedLuggageList = containedLuggageList;
    }
}
