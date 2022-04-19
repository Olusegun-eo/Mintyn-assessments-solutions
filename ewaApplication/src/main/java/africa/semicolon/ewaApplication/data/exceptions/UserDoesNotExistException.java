package africa.semicolon.ewaApplication.data.exceptions;

public class UserDoesNotExistException extends EwaAppException {
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
