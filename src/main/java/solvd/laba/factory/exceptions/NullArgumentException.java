package solvd.laba.factory.exceptions;

public class NullArgumentException extends IllegalArgumentException{
    public NullArgumentException(String errorMessage) {
        super(errorMessage);
    }

    public NullArgumentException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
