package pl.kkowalewski.restservice.exception;

public abstract class EmployeeException extends Exception {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    public EmployeeException() {
    }

    public EmployeeException(String message) {
        super(message);
    }

    public EmployeeException(Throwable cause) {
        super(cause);
    }
}
