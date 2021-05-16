package pl.kkowalewski.showroom.exception.service;

public class ShowroomNotFoundException extends RepositoryItemNotFoundException {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    public ShowroomNotFoundException() {
    }

    public ShowroomNotFoundException(String message) {
        super(message);
    }

    public ShowroomNotFoundException(Throwable cause) {
        super(cause);
    }
}
