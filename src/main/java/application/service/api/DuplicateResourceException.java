package application.service.api;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String countryIsWrong) {
        super(countryIsWrong);
    }

    public DuplicateResourceException(String message, Throwable e) {
        super(message, e);
    }
}