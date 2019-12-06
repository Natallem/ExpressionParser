package expression.exceptions.tabulatorException;

abstract public class TabulatorException extends Exception {
    protected   String message;

    public TabulatorException(String message) {
        this.message = message;
    }

    abstract public String getMessage();
}
