package pl.kkowalewski.showroom.exception.service;

public abstract class RepositoryItemNotFoundException extends Exception {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    public RepositoryItemNotFoundException() {
    }

    public RepositoryItemNotFoundException(String message) {
        super(message);
    }

    public RepositoryItemNotFoundException(Throwable cause) {
        super(cause);
    }
}
    