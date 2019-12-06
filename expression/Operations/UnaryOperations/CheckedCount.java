package expression.Operations.UnaryOperations;

import expression.TripleExpression;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.generic.typerOperator.Typer;

public class CheckedCount<T> extends UnaryOperation<T> {
    public CheckedCount(TripleExpression<T> tripleExpression, Typer<T> typer) {
        super(tripleExpression, typer);
    }

    @Override
    protected T doOperation(T x) throws EvaluateException {
        return typer.count(x);
    }
}
