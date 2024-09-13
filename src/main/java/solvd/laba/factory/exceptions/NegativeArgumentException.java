package solvd.laba.factory.exceptions;

public class NegativeArgumentException extends IllegalArgumentException{
    public NegativeArgumentException(String errorMessage) {
        super(errorMessage);
    }

    public NegativeArgumentException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
