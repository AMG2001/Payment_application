package daif.tech.util;

public class Validator {

    public static boolean isValidNumericOption(String option) {
        if(option.chars().anyMatch(character -> !Character.isDigit(character))){
            throw new IllegalArgumentException("Option must be numbers only");
        }
        return true;
    }
}
