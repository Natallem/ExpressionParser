package expression.exceptions.expressionException.parserException;

public class ConstantOverflowException extends ParserException {

    String wrongNumber;

    public ConstantOverflowException(NumberFormatException e, int index, String expression) {
        super(index, expression);
        wrongNumber = e.getMessage();
    }

    @Override
    public String getMessage() {
        String message = "Error in expression \"%s\".%nImpossible to parse \"%s\" because of overflow constant: %s" +
                "%nUse numbers in range [%d, %d]";
        return String.format(message,
                expression, expression.substring(index), wrongNumber, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
