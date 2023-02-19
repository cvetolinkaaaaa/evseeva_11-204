package Sinitsa;

public class SinitsaException extends Exception{
    public SinitsaException() {
    }

    public SinitsaException(String message) {
        super(message);
    }

    public SinitsaException(String message, Throwable cause) {
        super(message, cause);
    }

    public SinitsaException(Throwable cause) {
        super(cause);
    }

    public SinitsaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
