package solvd.laba.factory.exceptions;

public class InvalidStringException extends IllegalArgumentException{
    public InvalidStringException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidStringException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
