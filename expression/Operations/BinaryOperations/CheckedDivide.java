package expression.Operations.BinaryOperations;

import expression.TripleExpression;
import expression.exceptions.expressionException.evaluateException.*;
import expression.generic.typerOperator.Typer;


public class CheckedDivide<T> extends BinaryOperation<T> {
    public CheckedDivide(TripleExpression<T> first, TripleExpression<T> second, Typer<T> typer) {
        super(first, second, typer);
    }

    @Override
    protected T doOperation(T first, T second) throws EvaluateException {
        return typer.divide(first,second);
    }
}
