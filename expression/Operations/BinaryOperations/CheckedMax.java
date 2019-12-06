package expression.Operations.BinaryOperations;

import expression.TripleExpression;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.generic.typerOperator.Typer;

public class CheckedMax<T> extends BinaryOperation<T> {

    public CheckedMax(TripleExpression<T> first, TripleExpression<T> second, Typer<T> typer) {
        super(first, second, typer);
    }

    @Override
    protected T doOperation(T first, T second) throws EvaluateException {
        return typer.max(first,second);
    }
}