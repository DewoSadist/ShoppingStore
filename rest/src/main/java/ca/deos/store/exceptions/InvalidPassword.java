package ca.deos.store.exceptions;

public class InvalidPassword extends RuntimeException {

    public InvalidPassword() {
    }

    public InvalidPassword(String message) {
        super(message);
    }

    public InvalidPassword(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPassword(Throwable cause) {
        super(cause);
    }

    public InvalidPassword(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}