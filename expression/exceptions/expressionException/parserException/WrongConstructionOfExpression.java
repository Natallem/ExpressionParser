package expression.exceptions.expressionException.parserException;

public class WrongConstructionOfExpression extends ParserException {

    public WrongConstructionOfExpression(int index, String expression) {
        super(index, expression);
    }

    @Override
    public String getMessage() {
        return String.format("Error in expression \"%s\". ",
                expression, index);
    }
}
