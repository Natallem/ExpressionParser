package expression.Operations.BinaryOperations;

import expression.TripleExpression;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.generic.typerOperator.Typer;


abstract public class BinaryOperation<T> implements TripleExpression<T> {

    TripleExpression<T> first, second;
    Typer<T> typer;

    BinaryOperation(TripleExpression<T> first, TripleExpression<T> second, Typer<T> typer) {
        this.first = first;
        this.second = second;
        this.typer = typer;
    }

    public T evaluate(T x, T y, T z) throws EvaluateException {
        return doOperation(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    protected abstract T doOperation(T first, T second) throws EvaluateException;
}
