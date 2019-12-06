package expression.Operations.BinaryOperations;

import expression.TripleExpression;
import expression.exceptions.expressionException.evaluateException.*;
import expression.generic.typerOperator.Typer;


public class CheckedAdd<T> extends BinaryOperation<T> {

    public CheckedAdd(TripleExpression<T> first, TripleExpression<T> second, Typer<T> typer) {
        super(first, second, typer);
    }

    @Override
    protected T doOperation(T first, T second) throws EvaluateException {
        return typer.add(first,second);
    }
}
