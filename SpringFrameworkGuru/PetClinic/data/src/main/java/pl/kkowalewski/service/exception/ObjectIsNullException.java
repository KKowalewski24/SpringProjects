package pl.kkowalewski.service.exception;

public class ObjectIsNullException extends RuntimeException {

    public ObjectIsNullException() {
    }

    public ObjectIsNullException(String message) {
        super(message);
    }
}
