package za.co.wayne.j.robert.advent.of.code.puzzle;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayFourPuzzleSolver {

    private static final String[] EYE_COLOURS = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

    private FileReader fileReader;

    public DayFourPuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        List<String> inputLines = fileReader.readInput(inputFilePath);
        int validPassportCount = 0;
        Map<String, String> passportValues = new HashMap<>();
        for(String input: inputLines) {
            if (input.isEmpty()) {
                if (validatePassport(passportValues)) {
                    validPassportCount++;
                }
                passportValues = new HashMap<>();
            } else {
                String[] passportKeyValues = input.split(" ");
                for (String passportKeyValue : passportKeyValues) {
                    String[] keyValue = passportKeyValue.split(":");
                    passportValues.put(keyValue[0], keyValue[1]);
                }
            }
        }
        if (validatePassport(passportValues)) {
            validPassportCount++;
        }
        return validPassportCount;
    }

    private boolean validatePassport(Map<String, String> passportValues) {
        if (!passportValues.containsKey("byr")) {
            return false;
        }
        if (!passportValues.containsKey("iyr")) {
            return false;
        }
        if (!passportValues.containsKey("eyr")) {
            return false;
        }
        if (!passportValues.containsKey("hgt")) {
            return false;
        }
        if (!passportValues.containsKey("hcl")) {
            return false;
        }
        if (!passportValues.containsKey("ecl")) {
            return false;
        }
        if (!passportValues.containsKey("pid")) {
            return false;
        }
        return true;
    }

    public int solvePuzzleTwo(String inputFilePath) {
        List<String> inputLines = fileReader.readInput(inputFilePath);
        int validPassportCount = 0;
        Map<String, String> passportValues = new HashMap<>();
        for(String input: inputLines) {
            if (input.isEmpty()) {
                if (validatePassportWithValues(passportValues)) {
                    validPassportCount++;
                }
                passportValues = new HashMap<>();
            } else {
                String[] passportKeyValues = input.split(" ");
                for (String passportKeyValue : passportKeyValues) {
                    String[] keyValue = passportKeyValue.split(":");
                    passportValues.put(keyValue[0], keyValue[1]);
                }
            }
        }
        if (validatePassportWithValues(passportValues)) {
            validPassportCount++;
        }
        return validPassportCount;
    }

    private boolean validatePassportWithValues(Map<String, String> passportValues) {
        if (!passportValues.containsKey("byr")) {
            return false;
        } else {
            int year = Integer.parseInt(passportValues.get("byr"));
            if (year < 1920 || year > 2002) {
                return false;
            }
        }
        if (!passportValues.containsKey("iyr")) {
            return false;
        } else {
            int year = Integer.parseInt(passportValues.get("iyr"));
            if (year < 2010 || year > 2020) {
                return false;
            }
        }
        if (!passportValues.containsKey("eyr")) {
            return false;
        } else {
            int year = Integer.parseInt(passportValues.get("eyr"));
            if (year < 2020 || year > 2030) {
                return false;
            }
        }
        if (!passportValues.containsKey("hgt")) {
            return false;
        } else {
            String heightValue = passportValues.get("hgt");
            if (heightValue.contains("cm")) {
                int pos = heightValue.indexOf("cm");
                int height = Integer.parseInt(heightValue.substring(0, pos));
                if (height < 150 || height > 193) {
                    return false;
                }
            } else if (heightValue.contains("in")) {
                int pos = heightValue.indexOf("in");
                int height = Integer.parseInt(heightValue.substring(0, pos));
                if (height < 59 || height > 76) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (!passportValues.containsKey("hcl")) {
            return false;
        } else {
            String hairColour = passportValues.get("hcl");
            if (hairColour.length() != 7) {
                return false;
            } else {
                if (!hairColour.matches("^#\\d*[a-z]*[a-z\\d]*$")) {
                    return false;
                }
            }
        }
        if (!passportValues.containsKey("ecl")) {
            return false;
        } else {
            boolean found = false;
            String passportEyeColour = passportValues.get("ecl");
            for (String eyeColour: EYE_COLOURS) {
                if (passportEyeColour.equals(eyeColour)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        if (!passportValues.containsKey("pid")) {
            return false;
        } else {
            String passportId = passportValues.get("pid");
            if (!passportId.matches("\\d{9}")) {
                return false;
            }
        }
        return true;
    }
}
