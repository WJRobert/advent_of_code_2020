package za.co.wayne.j.robert.advent.of.code.puzzle.day.four;

import za.co.wayne.j.robert.advent.of.code.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PuzzleSolver {

    private static final String[] EYE_COLOURS = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

    private FileReader fileReader;

    public PuzzleSolver() {
        fileReader = new FileReader();
    }

    public int solvePuzzleOne(String inputFilePath) {
        return validatePuzzle(inputFilePath, true);
    }

    public int solvePuzzleTwo(String inputFilePath) {
        return validatePuzzle(inputFilePath, false);
    }

    private int validatePuzzle(String inputFilePath, boolean isSimpleValidation) {
        List<String> inputLines = fileReader.readInput(inputFilePath);
        int validPassportCount = 0;
        Map<String, String> passportValues = new HashMap<>();
        for (String input : inputLines) {
            if (input.isEmpty()) {
                if (validatePassport(passportValues, isSimpleValidation)) {
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
        if (validatePassport(passportValues, isSimpleValidation)) {
            validPassportCount++;
        }
        return validPassportCount;
    }

    private boolean validatePassport(Map<String, String> passportValues, boolean isSimpleMode) {
        return validateBirthYear(passportValues, isSimpleMode) &&
                validateIssueYear(passportValues, isSimpleMode) &&
                validateExpirationYear(passportValues, isSimpleMode) &&
                validateHeight(passportValues, isSimpleMode) &&
                validateHairColour(passportValues, isSimpleMode) &&
                validateEyeColour(passportValues, isSimpleMode) &&
                validatePassportId(passportValues, isSimpleMode);
    }

    private boolean validateBirthYear(Map<String, String> passportValues, boolean isSimpleMode) {
        if (!passportValues.containsKey(PassportField.BIRTH_YEAR.getFieldName())) {
            return false;
        } else if (!isSimpleMode) {
            int year = Integer.parseInt(passportValues.get(PassportField.BIRTH_YEAR.getFieldName()));
            return year >= 1920 && year <= 2002;
        }
        return true;
    }

    private boolean validateIssueYear(Map<String, String> passportValues, boolean isSimpleMode) {
        if (!passportValues.containsKey(PassportField.ISSUE_YEAR.getFieldName())) {
            return false;
        } else if (!isSimpleMode) {
            int year = Integer.parseInt(passportValues.get(PassportField.ISSUE_YEAR.getFieldName()));
            return year >= 2010 && year <= 2020;
        }
        return true;
    }

    private boolean validateExpirationYear(Map<String, String> passportValues, boolean isSimpleMode) {
        if (!passportValues.containsKey(PassportField.EXPIRE_YEAR.getFieldName())) {
            return false;
        } else if (!isSimpleMode) {
            int year = Integer.parseInt(passportValues.get(PassportField.EXPIRE_YEAR.getFieldName()));
            return year >= 2020 && year <= 2030;
        }
        return true;
    }

    private boolean validateHeight(Map<String, String> passportValues, boolean isSimpleMode) {
        if (!passportValues.containsKey(PassportField.HEIGHT.getFieldName())) {
            return false;
        } else if (!isSimpleMode) {
            String heightValue = passportValues.get(PassportField.HEIGHT.getFieldName());
            if (heightValue.contains("cm")) {
                int pos = heightValue.indexOf("cm");
                int height = Integer.parseInt(heightValue.substring(0, pos));
                return height >= 150 && height <= 193;
            } else if (heightValue.contains("in")) {
                int pos = heightValue.indexOf("in");
                int height = Integer.parseInt(heightValue.substring(0, pos));
                return height >= 59 && height <= 76;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean validateHairColour(Map<String, String> passportValues, boolean isSimpleMode) {
        if (!passportValues.containsKey(PassportField.HAIR_COLOUR.getFieldName())) {
            return false;
        } else if (!isSimpleMode) {
            String hairColour = passportValues.get(PassportField.HAIR_COLOUR.getFieldName());
            if (hairColour.length() != 7) {
                return false;
            } else {
                return hairColour.matches("^#\\d*[a-z]*[a-z\\d]*$");
            }
        }
        return true;
    }

    private boolean validateEyeColour(Map<String, String> passportValues, boolean isSimpleMode) {
        if (!passportValues.containsKey(PassportField.EYE_COLOUR.getFieldName())) {
            return false;
        } else if (!isSimpleMode) {
            boolean found = false;
            String passportEyeColour = passportValues.get(PassportField.EYE_COLOUR.getFieldName());
            for (String eyeColour : EYE_COLOURS) {
                if (passportEyeColour.equals(eyeColour)) {
                    found = true;
                    break;
                }
            }
            return found;
        }
        return true;
    }

    private boolean validatePassportId(Map<String, String> passportValues, boolean isSimpleMode) {
        if (!passportValues.containsKey(PassportField.PASSPORT_ID.getFieldName())) {
            return false;
        } else if (!isSimpleMode) {
            String passportId = passportValues.get(PassportField.PASSPORT_ID.getFieldName());
            return passportId.matches("\\d{9}");
        }
        return true;
    }
}
