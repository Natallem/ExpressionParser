package expression.exceptions.expressionException.parserException;

import expression.exceptions.expressionException.ExpressionException;

abstract public class ParserException extends ExpressionException {

    int index;
    String expression;

    public ParserException(int index, String expression) {
        this.index = index;
        this.expression = expression;
    }

}
