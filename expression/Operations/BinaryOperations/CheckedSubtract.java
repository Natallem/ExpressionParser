package expression.Operations.BinaryOperations;

import expression.TripleExpression;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.generic.typerOperator.Typer;

public class CheckedSubtract<T> extends BinaryOperation<T> {
    public CheckedSubtract(TripleExpression<T> first, TripleExpression<T> second, Typer<T> typer) {
        super(first, second, typer);
    }

    @Override
    protected T doOperation(T first, T second) throws EvaluateException {
        return typer.subtract(first,second);
    }
}
