package expression.exceptions.expressionException.parserException;

public class NoOperationException extends ParserException {
    public NoOperationException(int index, String expression) {
        super(index, expression);
    }

    @Override
    public String getMessage() {
        return String.format("Error in expression \"%s\".%n" +
                        "After \"%s\" expected an operation, found \"%s\".",
                expression, expression.substring(0, index), expression.substring(index));
    }
}
