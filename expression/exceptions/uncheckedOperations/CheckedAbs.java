package expression.exceptions.unaryOperations;


import expression.TripleExpression;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.exceptions.expressionException.evaluateException.OverflowException;

public strictfp class CheckedAbs extends UnaryOperation {

    public CheckedAbs(TripleExpression tripleExpression) {
        super(tripleExpression);
    }

    @Override
    protected int doOperation(int x) throws EvaluateException {
        if (x==Integer.MIN_VALUE) {
            throw new OverflowException("|"+x+"|");
        }
        if (x<0) {
            return -x;
        }
        else{
            return x;
        }
    }
}
