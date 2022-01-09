package dms;

public class UnknownFileTypeException extends RuntimeException{
    UnknownFileTypeException(final String message) {
        super(message);
    }
}
