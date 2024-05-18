package src;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}


public class Validator {
    private Set<Integer> ids = new HashSet<>();
    private static final Pattern NO_COMMAS_PATTERN = Pattern.compile("^[^,]+$");

    public void validateId(int id) throws ValidationException {
        if (ids.contains(id)) {
            throw new ValidationException("ID must be unique.");
        }
        ids.add(id);
    }

    public void validateNoCommas(String input, String fieldName) throws ValidationException {
        if (!NO_COMMAS_PATTERN.matcher(input).matches()) {
            throw new ValidationException(fieldName + " cannot contain commas.");
        }
    }

    public void validatePositiveFloat(double value, String fieldName) throws ValidationException {
        if (value <= 0) {
            throw new ValidationException(fieldName + " must be a positive number.");
        }
    }

    public void validatePositiveInt(int value, String fieldName) throws ValidationException {
        if (value <= 0) {
            throw new ValidationException(fieldName + " must be a positive integer.");
        }
    }

    public void validateBoolean(String value, String fieldName) throws ValidationException {
        if (!"true".equalsIgnoreCase(value) && !"false".equalsIgnoreCase(value)) {
            throw new ValidationException(fieldName + " must be 'true' or 'false'.");
        }
    }
}

