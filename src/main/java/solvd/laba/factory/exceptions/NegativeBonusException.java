package solvd.laba.factory.exceptions;

public class NegativeBonusException extends RuntimeException{
    public NegativeBonusException(String errorMessage) {
        super(errorMessage);
    }

    public NegativeBonusException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
