package expression;

import expression.exceptions.expressionException.evaluateException.EvaluateException;


/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface TripleExpression<T> {
    T evaluate(T x, T y, T z) throws EvaluateException;
}
