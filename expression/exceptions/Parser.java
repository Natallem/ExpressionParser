package expression.exceptions;

import expression.TripleExpression;
import expression.exceptions.expressionException.parserException.ParserException;


/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws ParserException;
}
