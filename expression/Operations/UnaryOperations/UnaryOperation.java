package expression.Operations.UnaryOperations;

import expression.TripleExpression;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.generic.typerOperator.Typer;

public abstract class UnaryOperation<T> implements TripleExpression<T> {

    TripleExpression<T> expression;
    Typer<T> typer;

    public UnaryOperation(TripleExpression<T> tripleExpression, Typer<T> typer) {
        expression = tripleExpression;
        this.typer = typer;
    }

    @Override
    public T evaluate(T x, T y, T z) throws EvaluateException {

        return doOperation(expression.evaluate(x, y, z));

    }

    abstract protected T doOperation(T x) throws EvaluateException;
}
