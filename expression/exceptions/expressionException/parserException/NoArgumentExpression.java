package expression.exceptions.expressionException.parserException;

public class NoArgumentExpression extends ParserException {

    public NoArgumentExpression(int index, String expression) {
        super(index, expression);
    }

    @Override
    public String getMessage() {
        if (index > expression.length()) index = expression.length();
        return String.format("Error in expression \"%s\".%n" +
                        "After \"%s\" expected an argument, found \"%s\".",
                expression, expression.substring(0, index), expression.substring(index));
    }
}
