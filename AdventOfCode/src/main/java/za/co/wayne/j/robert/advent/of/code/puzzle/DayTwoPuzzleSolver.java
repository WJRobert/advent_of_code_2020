package za.co.wayne.j.robert.advent.of.code.puzzle;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.List;

public class DayTwoPuzzleSolver {

    private FileReader fileReader;

    public DayTwoPuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int countValidPasswords = 0;
        for (String input: inputs) {
            String[] passwordTokens = input.split(":");
            if (isPasswordValidAccordingToSledCompany(passwordTokens[0].trim(), passwordTokens[1].trim())) {
                countValidPasswords++;
            }
        }
        return countValidPasswords;
    }

    private boolean isPasswordValidAccordingToSledCompany(String passwordPolicy, String password) {
        int pos = passwordPolicy.indexOf("-");
        int spacePos = passwordPolicy.indexOf(" ");
        int min = Integer.parseInt(passwordPolicy.substring(0, pos));
        int max = Integer.parseInt(passwordPolicy.substring(pos+1, spacePos));
        char characterToCheck = passwordPolicy.charAt(spacePos+1);

        int count = 0;
        int length = password.length();
        if (length < min) {
            return false;
        }
        for (int i=0; i<length; i++)  {
            if (characterToCheck == password.charAt(i)) {
                count++;
            }
            if (count > max) {
                return false;
            }
        }
        return count >= min;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputs = fileReader.readInput(inputFilePath);
        int countValidPasswords = 0;
        for (String input: inputs) {
            String[] passwordTokens = input.split(":");
            if (isPasswordValidAccordingTobogganCorp(passwordTokens[0].trim(), passwordTokens[1].trim())) {
                countValidPasswords++;
            }
        }
        return countValidPasswords;
    }

    private boolean isPasswordValidAccordingTobogganCorp(String passwordPolicy, String password) {
        int pos = passwordPolicy.indexOf("-");
        int spacePos = passwordPolicy.indexOf(" ");
        int positionOne = Integer.parseInt(passwordPolicy.substring(0, pos)) - 1;
        int positionTwo = Integer.parseInt(passwordPolicy.substring(pos+1, spacePos)) - 1;
        char characterToCheck = passwordPolicy.charAt(spacePos+1);

        int count = 0;
        if (characterToCheck == password.charAt(positionOne)) {
            count++;
        }
        if (characterToCheck == password.charAt(positionTwo)) {
            count++;
        }

        return  count == 1;
    }
}
