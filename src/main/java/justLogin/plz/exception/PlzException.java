package justLogin.plz.exception;

public abstract class PlzException extends RuntimeException {

    public PlzException(String message) {
        super(message);
    }

    public PlzException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();
}
