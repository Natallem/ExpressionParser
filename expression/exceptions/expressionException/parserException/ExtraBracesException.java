package expression.exceptions.expressionException.parserException;

public class ExtraBracesException extends ParserException {


    public ExtraBracesException(int index, String expression) {
        super(index, expression);
    }

    @Override
    public String getMessage() {
        return String.format("Error in expression \"%s\". Extra braces:  \"%s\"",
                expression, expression.substring(index));
    }
}
