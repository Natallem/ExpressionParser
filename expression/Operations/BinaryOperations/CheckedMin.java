package expression.Operations.BinaryOperations;

import expression.TripleExpression;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.generic.typerOperator.Typer;

public class CheckedMin<T> extends BinaryOperation<T> {

    public CheckedMin(TripleExpression<T> first, TripleExpression<T> second, Typer<T> typer) {
        super(first, second, typer);
    }

    @Override
    protected T doOperation(T first, T second) throws EvaluateException {
        return typer.min(first,second);
    }
}
