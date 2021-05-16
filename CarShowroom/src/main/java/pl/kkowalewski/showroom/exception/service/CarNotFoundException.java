package pl.kkowalewski.showroom.exception.service;

public class CarNotFoundException extends RepositoryItemNotFoundException {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    public CarNotFoundException() {
    }

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(Throwable cause) {
        super(cause);
    }
}
