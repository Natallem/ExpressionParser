package expression.exceptions.tabulatorException;

public class UnknownModeException extends TabulatorException {

    public UnknownModeException(String message) {
       super(message);
    }

    @Override
    public String getMessage() {
        return "Unknown mode: " + message;
    }
}
